package com.webshop.simplewebapplication.database.Garanty;

import com.webshop.simplewebapplication.model.Garanty;

import java.util.ArrayList;
import java.util.List;

public interface GarantyDAO {
    List<Garanty> getOverdue();
    List<Garanty> getActive();
    List<Garanty> getAll();
    void addGaranty(Garanty garanty);
    Garanty findByID(int id);
    void deleteGaranty(Garanty garanty);
}
