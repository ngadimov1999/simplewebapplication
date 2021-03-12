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
    GarantyService garantyService = new GarantyService();

    @Autowired
    EmailController emailController = new EmailController();

    @Scheduled(initialDelay = 30 * 1000, fixedDelay = 60 * 60 * 1000)
    public void writeMails() {
        GarantyService garantyService = new GarantyService();
        List<Garanty> overdue = garantyService.getOverdue();
        for (Garanty overdueGar : overdue){
            emailController.sendSimpleEmail("gadimovnabi@gmail.com",
                                          "Здравствуйте! Спешим напомнить, что ваша гарантия на устройство '" + overdueGar.getDevice().getModel() + "' истекает через месяц, не забудьте оформить новую!",
                                            "Истекает срок гарантии");
        }
    }

}