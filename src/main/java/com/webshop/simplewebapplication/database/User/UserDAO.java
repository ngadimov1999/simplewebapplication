package com.webshop.simplewebapplication.database.User;

import com.webshop.simplewebapplication.model.Usr;

public interface UserDAO {
    Usr findByLogin(String login);

    void addUser(Usr usr);
}
