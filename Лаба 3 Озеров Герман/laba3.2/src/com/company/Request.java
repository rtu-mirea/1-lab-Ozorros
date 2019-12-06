package com.company;

import java.util.Scanner;

public class Request {

    private Client requester;
    private  String job; // должность
    private int payment; // з.п
    private int hoursInWork; // Часы работы
    private  int type; // Работодатель или работник




   public Request(Client requester,String job,int payment,int hours,int type){
        this.job = job;
        this.payment = payment;
        hoursInWork = hours;
        this.requester = new Client();
        this.type = type;
    }

    public Request() {
        this.job = null;
        this.payment = 0;
        hoursInWork = 0;
        this.requester = new Client();
        this.type = 0;
    }


    public Client getRequester() {
        return requester;
    }

    public void setRequester(Client requester) {
        this.requester = requester;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getHoursInWork() {
        return hoursInWork;
    }

    public void setHoursInWork(int hoursInWork) {
        this.hoursInWork = hoursInWork;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
