package com.xn2001.college.service.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xn2001.college.service.edu.entity.CourseCollect;
import com.xn2001.college.service.edu.entity.vo.CourseCollectVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程收藏 Mapper 接口
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
@Repository
public interface CourseCollectMapper extends BaseMapper<CourseCollect> {
    List<CourseCollectVo> selectPageByMemberId(String memberId);
}
