package com.webshop.simplewebapplication.Service;

import com.webshop.simplewebapplication.database.Garanty.GarantyDAOHib;
import com.webshop.simplewebapplication.model.Garanty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarantyService {

    @Autowired
    GarantyDAOHib garantyDao;

    public List<Garanty> getOverdue() {
        return garantyDao.getOverdue();
    }

    public List<Garanty> getActive() {
        return garantyDao.getActive();
    }

    public List<Garanty> getAll() {
        return garantyDao.getAll();
    }

    public void addGaranty(Garanty garanty) {
        garantyDao.addGaranty(garanty);
    }

    public Garanty findById(int id) {
        return garantyDao.findByID(id);
    }

    public void deleteGaraty(Garanty garanty) {
        garantyDao.deleteGaranty(garanty);
    }
}
