package com.xn2001.college.service.ucenter.entity.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/29 19:42
 **/
@Data
public class RegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "昵称不能为空")
    private String nickname;
    private String mobile;
    @Email(message = "邮箱格式不对")
    private String email;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "验证码不能为空")
    private String code;
}
