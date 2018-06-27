package com.lingnan;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by Administrator on 2018/6/27.
 */
public class MailTest {

    private ApplicationContext context;
    private JavaMailSender sender;

    @Before
    public void init(){
        this.context = new ClassPathXmlApplicationContext(
           "config/application*"
        ) ;

        this.sender = this.context.getBean(JavaMailSender.class);
    }

    @Test
    public void testSendingMail(){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("743834110@qq.com");
        mailMessage.setTo("2569193508@qq.com");
        mailMessage.setSubject("Mail Test");
        mailMessage.setText("Hello World");
        this.sender.send(mailMessage);
        System.out.println("邮件发送完毕");
    }
}
