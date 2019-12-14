package com.company;

import java.util.Scanner;

public class Client extends User {

    Client(String n, String l, String p) {
        super(n, l, p);
    }

    public Client() { }

    public void takeResult(Request request)
    {

        System.out.println("Ваша заяка одобрена");
        System.out.println("Ваш работодатель "+ request.getRequester().getName());

    }


}
