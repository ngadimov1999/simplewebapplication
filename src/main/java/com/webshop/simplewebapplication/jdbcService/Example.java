package com.webshop.simplewebapplication.jdbcService;

import com.webshop.simplewebapplication.jdbcService.dataSets.UsersDataSet;

public class Example {
    private DBService dbService = new DBService();

    public void getUser() {
        String login = "nabi";
        UsersDataSet userProfile = null;
        try {
            userProfile = dbService.getUser(login);
            System.out.println(userProfile.getLogin());
            System.out.println(userProfile.getPassword());
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public void setUser() {
        String login = "nabi123";
        String password = "123";
        UsersDataSet userProfile = new UsersDataSet(login, password);
        try {
            dbService.addUser(userProfile);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
