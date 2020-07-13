package com.xn2001.college.service.edu.service;

import com.xn2001.college.service.edu.entity.Course;
import com.xn2001.college.service.edu.entity.form.CourseInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
