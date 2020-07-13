package com.xn2001.college.service.edu.controller;

import com.xn2001.college.common.base.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author 乐心湖
 * @date 2020/6/29 19:43
 **/
@CrossOrigin //跨域
@RestController
@RequestMapping("/user")
public class LoginController {

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("info")
    public R info() {
        return R.ok()
                .data("roles", "[admin]")
                .data("name", "admin")
                .data("avatar", "https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("logout")
    public R logout() {
        return R.ok();
    }
}
