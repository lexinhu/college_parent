package com.xn2001.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/16 3:22
 **/
@Data
public class CoursePublishVo  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectParentTitle;
    private String subjectTitle;
    private String teacherName;
    private String price; //只用于显示
}
