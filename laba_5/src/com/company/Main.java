package com.company;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JFrame {
    public static ArrayList<User> Users;
    public static ArrayList<Request> workerRequests;
    public static ArrayList<Request> employerRequest;
    public static User currentUser;

    public static User addUser(String name, String login, String password){
        return new Client(name, login, password);
    }

    public static void main(String[] args) {
        Users = new ArrayList<User>();
        Admin admin;
        admin = new Admin("admin", "admin", "admin");
        Users.add(admin);
        new GUI().Menu();
    }
}


