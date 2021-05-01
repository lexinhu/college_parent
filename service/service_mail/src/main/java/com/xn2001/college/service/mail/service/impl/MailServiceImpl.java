package com.xn2001.college.service.mail.service.impl;

import com.xn2001.college.service.mail.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 乐心湖
 * @date 2021/2/19 17:04
 **/
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendCode(String email, String subject, String checkCode, String template) throws Exception {

        // 获得模板
        Template templateTem = freeMarkerConfigurer.getConfiguration().getTemplate(template);
        // 使用Map作为数据模型，定义属性和值
        Map<String, Object> model = new HashMap<>();
        // 将验证码放入model
        model.put("code", checkCode);
        // 传入数据模型到模板，替代模板中的占位符，并将模板转化为html字符串
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(templateTem, model);

        //设置一些必要的值
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail); //发送人的邮箱
        message.setSubject(subject); //标题
        helper.setTo(email); //接收人的邮箱

        //第一个参数：模板
        //第二个参数：格式是否为html
        helper.setText(templateHtml, true);
        //发送邮件
        mailSender.send(message);
    }

}
