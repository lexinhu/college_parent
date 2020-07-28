package com.xn2001.college.service.edu.service;

import com.xn2001.college.service.edu.entity.Teacher;
import com.xn2001.college.service.edu.entity.vo.TeacherQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

    List<Map<String, Object>> selectNameListByKey(String key);

    boolean removeAvatarById(String id);

    /**
     * 根据讲师id获取讲师详情页数据
     *
     * @param id
     * @return
     */
    Map<String, Object> selectTeacherInfoById(String id);

    List<Teacher> selectHotTeacher();
}
