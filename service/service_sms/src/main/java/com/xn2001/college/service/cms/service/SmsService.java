package com.xn2001.college.service.cms.service;

import com.aliyuncs.exceptions.ClientException;

/**
 * @author 乐心湖
 * @date 2020/7/29 18:44
 **/
public interface SmsService {
    void send(String mobile, String checkCode) throws ClientException;
}
