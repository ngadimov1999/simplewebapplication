package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Scheduler.SendMailScheduler;
import com.webshop.simplewebapplication.Service.DeviceService;
import com.webshop.simplewebapplication.Service.GarantyService;
import com.webshop.simplewebapplication.model.Device;
import com.webshop.simplewebapplication.model.Garanty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ShowController {

    static final Logger logger = LoggerFactory.getLogger(ShowController.class);

    @Autowired
    GarantyService garantyService;
    @Autowired
    DeviceService deviceService;

    @GetMapping("/")
    public ModelAndView index() {
        List<Device> devices = deviceService.findAll();
        logger.info("Выведены все устройства");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("devices", devices);
        return modelAndView;
    }

    @GetMapping("/garanty")
    public ModelAndView garanty() {
        List<Garanty> garanties = garantyService.getAll();
        logger.info("Все гарантийники");
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Просроченные");
        categories.add("Действующие");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("garanty");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("garanties", garanties);
        return modelAndView;
    }

    @RequestMapping(path = "/category/{name}/show", method = RequestMethod.GET)
    public ModelAndView showCategory(@PathVariable("name") String name) {
        ArrayList<Garanty> garanties;

        if (name.equals("Просроченные")){
            garanties = (ArrayList<Garanty>) garantyService.getOverdue();
        }else {
            garanties = (ArrayList<Garanty>) garantyService.getActive();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("garanty");
        modelAndView.addObject("garanties", garanties);
        modelAndView.addObject("return", true);
        modelAndView.addObject("categ", name);
        logger.info("Показаны гарантии");
        return modelAndView;
    }

    @RequestMapping(path = "/garanty/{id}/show", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable("id") int id) {
        Garanty garanty = garantyService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info");
        modelAndView.addObject("garanty", garanty);
        logger.info("Показаны детали гарантии");
        return modelAndView;
    }
}
