package com.xn2001.college.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xn2001.college.common.base.result.R;
import com.xn2001.college.service.edu.entity.Course;
import com.xn2001.college.service.edu.entity.Teacher;
import com.xn2001.college.service.edu.entity.vo.TeacherQueryVo;
import com.xn2001.college.service.edu.feign.OssFileService;
import com.xn2001.college.service.edu.mapper.CourseMapper;
import com.xn2001.college.service.edu.mapper.TeacherMapper;
import com.xn2001.college.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private OssFileService ossFileService;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Page<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo) {

        //条件构造器
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        //排序
        wrapper.orderByAsc("sort");
        //普通的排序分页查询
        if (teacherQueryVo == null) {
            return baseMapper.selectPage(pageParam, wrapper);
        }

        //获取对象参数
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        //条件
        if (!StringUtils.isEmpty(name)) {
            wrapper.likeRight("name", name);
        }

        if (level != null) {
            wrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(joinDateBegin)) {
            wrapper.ge("join_date", joinDateBegin);
        }

        if (!StringUtils.isEmpty(joinDateEnd)) {
            wrapper.le("join_date", joinDateEnd);
        }

        return baseMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectNameListByKey(String key) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name");
        queryWrapper.likeRight("name", key);

        return baseMapper.selectMaps(queryWrapper);
    }

    @Override
    public boolean removeAvatarById(String id) {
        //根据ID查询讲师Avatar头像url地址
        Teacher teacher = baseMapper.selectById(id);

        if (teacher != null) {
            String avatar = teacher.getAvatar();
            if (!StringUtils.isEmpty(avatar)) {
                R r = ossFileService.removeFile(avatar);
                return r.getSuccess();
            }
        }
        return false;
    }

    @Override
    public boolean updateById(Teacher entity) {
        //根据ID查询讲师原的 Avatar 头像url地址并对比进行删除
        Teacher teacher = baseMapper.selectById(entity.getId());
        if (!StringUtils.isEmpty(teacher.getAvatar()) && !teacher.getAvatar().equals(entity.getAvatar())) {
            ossFileService.removeFile(teacher.getAvatar());
        }
        return super.updateById(entity);
    }


    /**
     * 根据讲师id获取讲师详情页数据
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> selectTeacherInfoById(String id) {
        //获取讲师信息
        Teacher teacher = baseMapper.selectById(id);
        //根据讲师id获取讲师课程
        List<Course> courseList = courseMapper.selectList(new QueryWrapper<Course>().eq("teacher_id", id));
        Map<String, Object> map = new HashMap<>();
        map.put("teacher", teacher);
        map.put("courseList", courseList);
        return map;
    }

    @Cacheable(value = "index", key = "'selectHotTeacher'")
    @Override
    public List<Teacher> selectHotTeacher() {

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        queryWrapper.last("limit 4");
        return baseMapper.selectList(queryWrapper);
    }
}
