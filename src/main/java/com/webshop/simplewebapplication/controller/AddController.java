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

import javax.xml.bind.helpers.DefaultValidationEventHandler;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@RestController
public class AddController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    GarantyService garantyService;

    static final Logger logger = LoggerFactory.getLogger(AddController.class);

    @PostMapping("/add")
    public ModelAndView add(@RequestParam("model") String model)  {
        deviceService.addDevice(new Device(0, model));
        logger.info("Добавлен девайс");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addDevice");
        logger.info("Страница добавления");
        return modelAndView;
    }

    @RequestMapping(path = "/add/{id}/{date}/garanty", method = RequestMethod.POST)
    public void addGarantyToDevice(@PathVariable("id") int id,
                                    @PathVariable("date") String date) {
        Date dt = new Date();
        String[] data = date.split("-");
        dt.setYear(Integer.parseInt(data[0]) - 1900);
        dt.setMonth(Integer.parseInt(data[1]) - 1);
        dt.setDate(Integer.parseInt(data[2]));
        Device device = deviceService.findById(id);
        Garanty garanty = new Garanty(0,dt,device);
        garantyService.addGaranty(garanty);
        logger.info("Добавлена гарантия к девайсу");
    }
}
