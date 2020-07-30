package com.xn2001.college.service.ucenter.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/29 19:42
 **/
@Data
public class RegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String mobile;
    private String password;
    private String code;
}
