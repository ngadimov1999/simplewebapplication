package com.webshop.simplewebapplication.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "device")
public class Device {

    public Device(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;


    public Device(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
