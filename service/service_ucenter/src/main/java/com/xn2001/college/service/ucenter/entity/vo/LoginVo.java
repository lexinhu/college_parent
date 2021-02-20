package com.xn2001.college.service.ucenter.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author 乐心湖
 * @date 2020/7/31 23:25
 **/
@Data
public class LoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "手机号或邮箱不能为空")
    private String userInfo;
    private String password;
}
