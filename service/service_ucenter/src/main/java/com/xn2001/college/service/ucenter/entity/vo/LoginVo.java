package com.xn2001.college.service.ucenter.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/31 23:25
 **/
@Data
public class LoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mobile;
    private String password;
}
