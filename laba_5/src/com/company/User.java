package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private String login;
    private String password;

    User() {
        name = "";
        login = "";
        password = "";
    }

    User(String name, String login, String password){

        this.name = name ; // Имя пользователя
        this.login = login; // Логин пользователя
        this.password = password; // Пароль пользователя

    }

    public boolean enter(String login, String password)
    {
        if (this.login.equals(login) && this.password.equals(password))
            return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
