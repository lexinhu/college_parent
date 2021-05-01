package com.xn2001.college.service.mail.controller;

import com.netflix.client.ClientException;
import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.FormUtils;
import com.xn2001.college.common.base.util.RandomUtils;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.mail.service.MailService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 乐心湖
 * @date 2021/2/19 16:58
 **/
@RestController
@RequestMapping("/api/mail")
@Api(tags = "邮箱验证码")
@Slf4j
public class ApiMailController {
    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("send/{email}")
    public R getCode(@PathVariable String email) {

        //校验邮箱是否合法
        if (StringUtils.isEmpty(email) || !FormUtils.isEmail(email)) {
            return R.error().message("请输入正确的邮箱");
        }
        //生成验证码
        String checkCode = RandomUtils.getFourBitRandom();
        //发送验证码
        try {
            mailService.sendCode(email, "小湖视频网-注册验证码", checkCode, "code.html");
        } catch (Exception e) {
            throw new CollegeException(ResultCodeEnum.MAIL_ERROR);
        }
        //将验证码存入redis缓存
        redisTemplate.opsForValue().set(email, checkCode, 5, TimeUnit.MINUTES);

        return R.ok().message("邮件发送成功");
    }
}
