package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LabourSystem {

    private ArrayList<User> Users;
    private ArrayList<Request> workerRequests;
    private ArrayList<Request> employerRequest;
    private User currentUser;

    LabourSystem() {
        Users = new ArrayList<User>();
        currentUser = new User();
        workerRequests = new ArrayList<Request>();
        employerRequest = new ArrayList<Request>();

    }


    public void main() {


            Scanner s = new Scanner(java.lang.System.in);
            Scanner sc = new Scanner(java.lang.System.in);

            LabourSystem ls = new LabourSystem();

            int n;
            int num1 = 0;
            int num = 0;
            while (num != 3) {
                Scanner in = new Scanner(java.lang.System.in);
                System.out.println("\n" + "Какие действия вы хотете выполнить?");
                System.out.println("1. Войти в систему");
                System.out.println("2. Зарегистрироваться");
                System.out.println("3. Выйти");
                System.out.print("Выберите действие.");
                num = in.nextInt();
                switch (num)
                {
                    case 1:
                        String l = null;
                        System.out.print("Ваш логин: ");
                        l = s.nextLine();

                        String p = null;
                        System.out.print("Ваш пароль:");
                        p = s.nextLine();

                        ls.currentUser = ls.findUser(l,p);

                        if (ls.currentUser != null)
                        {
                            System.out.println("Привет " + ls.currentUser.getName() + "!!!!!!!");
                            System.out.println("Какие действия вы хотете выполнить?");
                            System.out.println("1. Подать заявку");
                            System.out.println("2. Посмотреть заявку");
                            System.out.println("3. Выйти");

                            num1 = in.nextInt();
                            switch (num1) {
                                case 1:
                                    createRequest();
                                    break;
                                case 2:
                                    processRequests();
                                    break;
                                case 3:
                                    break;

                            }

                        } else System.out.println("Такого пользователя не существует");
                        break;
                    case 2:


                        System.out.println("______________________________Регистрация______________________________");
                        System.out.println("Чтобы зарегестрироваться вам необходимо ввести ФИО,свой логин и пороль!");

                        String name = null;
                        System.out.print("Ваше ФИО:");
                        name = s.nextLine();

                        String login = null;
                        System.out.print("Ваш логин: ");
                        login = s.nextLine();

                        String password = null;
                        System.out.print("Ваш пароль:");
                        password = s.nextLine();

                        ls.addUser(name,login,password);
                        break;
                    case 3:

                        return;

                }

            }

        }

        private void addUser(String name, String login, String password) {

            Scanner s = new Scanner(java.lang.System.in);

            boolean q = true;
            if (Users.isEmpty()) q = false;

            while (q)
            {
                int k = 0;
                q = false;

                while (k < Users.size())
                {
                    if ((Users.get(k)).getLogin().equals(login)) {
                        q = true;
                        System.out.println("Такой логин уже существует! Повторите попытку!");
                        break;
                    }
                    k++;
                }
                if (q)
                {
                    System.out.print("Ваш логин:");
                    login = s.nextLine();
                }

            }

            User a = new User(name, login, password);

            Users.add(a);
        }

        private User findUser(String login, String password)
        {
            for (User user:Users) {
                if(user.enter(login,password)){
                    return user;
                }
            }
            return null;
        }


        private void clearWorkerRequests(Client worker) {
            workerRequests.removeIf(r -> r.getRequester().equals(worker));
        }

        private void processRequests(){

            for(Request r:employerRequest){
                for(Request req:workerRequests){
                    if(srav(req,r)==2){
                        req.getRequester().takeResult(r);
                        clearWorkerRequests(req.getRequester());
                    }
                }
            }


        }

        private void createRequest(){
            Scanner or = new Scanner(java.lang.System.in);
            Scanner orr = new Scanner(java.lang.System.in);

            Request r = new Request();

            System.out.println("______________________________Заполнение заявки______________________________");

            System.out.print("Вы работодатель?:\n0 - Нет\n1 - Да ");
            int t = or.nextInt();

            while ((t < 0) || (t > 1))
            {
                System.out.print("Вы работодатель?:\n0 - Нет\n1 - Да ");
                t = or.nextInt();
            }

            r.setType(t);

            System.out.print("Введите должность: " );
            r.setJob(orr.nextLine());



            System.out.print("Введите зарплату: " );
            r.setPayment(or.nextInt());

            System.out.print("Введите время работы: " );
            r.setHoursInWork(or.nextInt());

            if (r.getType() == 0) {
                workerRequests.add(r);
            } else {
                employerRequest.add(r);
            }
        }

    public int srav(Request work,Request emp) // сравнивает заявки (работодателя и работника)
    {
        int k = 0;
        if (!(work.getJob()).equals(emp.getJob())) return 0;

        if ((work.getPayment() <= emp.getPayment()) || (work.getPayment() >= emp.getPayment()-5)) k++;

        if ((work.getHoursInWork() >= emp.getHoursInWork()) || (work.getHoursInWork()+2 >= emp.getHoursInWork())) k++;


        return k;
    }

}




