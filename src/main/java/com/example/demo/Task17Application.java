package com.example.demo;

import com.example.demo.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Task17Application {

    @Autowired
    private EmailSenderService emailSenderService;
    public static void main(String[] args) {
        SpringApplication.run(Task17Application.class, args);
    }
// @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//        emailSenderService.sendMail("dhvbdjkfbv");
// }
}
