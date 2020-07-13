package com.atguigu.guli.service.edu.mapper;

import com.atguigu.guli.service.edu.entity.Subject;
import com.atguigu.guli.service.edu.entity.vo.SubjectVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    List<SubjectVo> selectNestedList(String parentId);
}
