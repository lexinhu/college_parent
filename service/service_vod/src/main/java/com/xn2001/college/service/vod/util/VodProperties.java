package com.xn2001.college.service.vod.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 乐心湖
 * @date 2020/7/18 14:34
 **/
@Data
@Component
@ConfigurationProperties(prefix="qcloud")
public class VodProperties {
    private String secretId;
    private String secretKey;
}
