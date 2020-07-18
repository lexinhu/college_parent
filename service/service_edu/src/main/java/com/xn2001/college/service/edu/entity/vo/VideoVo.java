package com.xn2001.college.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/16 19:12
 **/
@Data
public class VideoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Boolean free;
    private Integer sort;

    private String videoSourceId;
}
