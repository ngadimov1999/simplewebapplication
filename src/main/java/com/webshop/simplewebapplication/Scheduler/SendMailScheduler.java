package com.webshop.simplewebapplication.Scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.webshop.simplewebapplication.Service.GarantyService;
import com.webshop.simplewebapplication.controller.EmailController;
import com.webshop.simplewebapplication.model.Garanty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMailScheduler {

    @Autowired
    GarantyService garantyService;

    @Autowired
    EmailController emailController;

    @Scheduled(initialDelay = 2 * 1000, fixedDelay = 60 * 60 * 1000)
    public void writeMails() {
        GarantyService garantyService = new GarantyService();
        List<Garanty> overdue = garantyService.getOverdue();
        for (Garanty overdueGar : overdue){
            emailController.sendSimpleEmail();
        }
    }

}