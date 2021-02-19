package com.xn2001.college.service.mail.service;

/**
 * @author 乐心湖
 * @date 2021/2/19 17:04
 **/
public interface MailService {
    void sendCode(String email, String subject, String checkCode, String template) throws Exception;
}
