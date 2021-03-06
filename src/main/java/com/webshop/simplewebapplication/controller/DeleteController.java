package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.DeviceService;
import com.webshop.simplewebapplication.Service.GarantyService;
import com.webshop.simplewebapplication.model.Device;
import com.webshop.simplewebapplication.model.Garanty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DeleteController {

    @Autowired
    GarantyService garantyService;

    static final Logger logger = LoggerFactory.getLogger(DeleteController.class);

    @RequestMapping(path = "/device/{id}/delete", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable("id") int id) {
//        Если есть гарантии то сначала их удалить
        DeviceService deviceService = new DeviceService();
        deviceService.deleteDevice(id);
        logger.info("Удален девайс");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(path = "/device/{id}/delete/garanty", method = RequestMethod.POST)
    public ModelAndView deleteFromDevice(@PathVariable("id") int id) {
        Garanty garanty = garantyService.findById(id);
        garantyService.deleteGaraty(garanty);
        logger.info("Удален гарантийник");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("garanty");
        return modelAndView;
    }
}
