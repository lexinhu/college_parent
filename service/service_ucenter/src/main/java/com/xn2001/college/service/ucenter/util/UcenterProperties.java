package com.xn2001.college.service.ucenter.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 乐心湖
 * @date 2020/8/1 22:31
 **/
@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="wx.open")
public class UcenterProperties {
    private String appId;
    private String appSecret;
    private String redirectUri;
}
