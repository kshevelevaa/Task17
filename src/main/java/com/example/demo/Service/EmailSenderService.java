package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@EnableAsync
@Service
public class EmailSenderService  {


    public static final String EMAIL = "k.shevelevaa@mail.ru";
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotification() throws MailException {

        System.out.println("Sending email...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(EMAIL);
        mail.setFrom(EMAIL);
        mail.setText("какое-то очень важное письмо");

        javaMailSender.send(mail);

        System.out.println("Email Sent!");
    }

}
