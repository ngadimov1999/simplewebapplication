package com.webshop.simplewebapplication.Service;

import com.webshop.simplewebapplication.database.Device.DeviceDAOHib;
import com.webshop.simplewebapplication.model.Device;
import com.webshop.simplewebapplication.model.Garanty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceDAOHib dataBase = new DeviceDAOHib();

    public boolean addDevice(Device device) {
        dataBase.addDevice(device);
        return true;
    }

    public List<Device> findAll() {
        return dataBase.findAll();
    }


    public Device findById(int id) {
        return dataBase.findById(id);
    }

    public int countOfDevices(){
        return dataBase.countOfDevices();
    }

    public boolean deleteDevice(int id) {
        dataBase.deleteDevice(id);
        return true;
    }

    public void changeDevice(Device device, String model) {
        dataBase.changeDevice(device, model);
    }
}
