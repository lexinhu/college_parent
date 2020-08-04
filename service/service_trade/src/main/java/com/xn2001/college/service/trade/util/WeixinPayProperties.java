package com.xn2001.college.service.trade.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 乐心湖
 * @date 2020/8/4 18:26
 **/
@Data
@Component
@ConfigurationProperties(prefix="weixin.pay")
public class WeixinPayProperties {
    private String appId;
    private String partner;
    private String partnerKey;
    private String notifyUrl;
}
