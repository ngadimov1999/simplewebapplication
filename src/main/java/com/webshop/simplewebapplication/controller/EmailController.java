package com.webshop.simplewebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleEmail(String email, String message, String theme) {

        // Create a Simple MailMessage.
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo("gadimovnabi@gmail.com");
//        message.setSubject("Test Simple Email");
//        message.setText("Hello, Im testing Simple Email");

        System.out.println("TO: " + email + "\nTHEME: " + theme + "\nMESSAGE: " + message);

        // Send Message!
//        this.emailSender.send(message);
    }
}