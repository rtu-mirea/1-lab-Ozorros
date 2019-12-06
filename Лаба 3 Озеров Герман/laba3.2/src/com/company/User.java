package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String n, String l, String p){

        name = n ; // Имя пользователя
        login = l; // Логин пользователя
        password = p; // Пароль пользователя

    }

    public User() {
        name = new String ();
        login = new String ();
        password = new String ();
    }


    public boolean enter(String l, String p)
    {

        return this.getLogin().equals(l) && this.getPassword().equals(p);
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
