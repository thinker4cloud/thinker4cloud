package com.thinker4cloud.thinker.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev@panjunye.com on 2019/03/29.
 */

@RestController
public class EmailController {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @RequestMapping("email/send")
    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("414185353@qq.com");
        message.setFrom("414185353@qq.com");
        message.setSubject("this is test mail");
        message.setText("hello, this is test mail.");
        emailSender.send(message);
    }
}
