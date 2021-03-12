package com.webshop.simplewebapplication.jdbcService.dao;

import com.webshop.simplewebapplication.jdbcService.dataSets.UsersDataSet;
import com.webshop.simplewebapplication.jdbcService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UsersDataSet getUser(String login) throws SQLException {
        return executor.execQuery("select * from usr where login='" + login + "'", result -> {
            result.next();
            return new UsersDataSet(result.getString(2),
                    result.getString(3));
        });
    }

    public boolean checkUserExists(String login) throws SQLException {
        return executor.execQuery("select exists (select * from usr where login='" + login + "')", result -> {
            result.next();
            return result.getBoolean(1);
        });
    }

    public void insertUser(String login, String password) throws SQLException {
        executor.execUpdate("insert into usr (login, password) values ('" + login + "', '" + password + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists usr (id bigint auto_increment primary key, login varchar(255), password varchar(255))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table usr");
    }
}
