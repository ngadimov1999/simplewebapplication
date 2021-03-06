package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.DeviceService;
import com.webshop.simplewebapplication.model.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ChangeController {

    static final Logger logger = LoggerFactory.getLogger(ChangeController.class);

    @Autowired
    DeviceService deviceService;

    @PostMapping("/change")
    public ModelAndView change(@RequestParam("model") String model,
                               @RequestParam("device") int id)  {
        Device device = deviceService.findById(id);
        deviceService.changeDevice(device, model);
        logger.info("Изменен девайс");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/change")
    public ModelAndView change(){
        List<Device> devices = deviceService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("changeDevice");
        modelAndView.addObject("devices", devices);
        logger.info("Страница изменения");
        return modelAndView;
    }
}
