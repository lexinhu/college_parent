package com.xn2001.college.service.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xn2001.college.service.edu.entity.Subject;
import com.xn2001.college.service.edu.entity.vo.SubjectVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
@Repository
public interface SubjectMapper extends BaseMapper<Subject> {

    List<SubjectVo> selectNestedList(String parentId);
}
