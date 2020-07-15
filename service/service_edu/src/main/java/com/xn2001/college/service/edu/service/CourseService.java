package com.xn2001.college.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xn2001.college.service.edu.entity.Course;
import com.xn2001.college.service.edu.entity.form.CourseInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.edu.entity.vo.CourseQueryVo;
import com.xn2001.college.service.edu.entity.vo.CourseVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface CourseService extends IService<Course> {

    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    IPage<CourseVo> selectPage(Long page, Long limit, CourseQueryVo courseQueryVo);

    boolean removeCoverById(String id);

    boolean removeCourseById(String id);
}
