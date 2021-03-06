package com.webshop.simplewebapplication.model;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class Usr {

    public Usr(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;

    @Column
    private String password;


    public Usr(int user_id, String login, String password) {
        this.id = user_id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
