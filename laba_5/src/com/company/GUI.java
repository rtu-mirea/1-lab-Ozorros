package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GUI {




    public void Menu(){
        JFrame frame = new JFrame("Меню");
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.setSize(300, 110);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Регистрация");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b2 = new JButton("Вход");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b3 = new JButton("Выход");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Authorization();
                frame.dispose();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });



        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void Registration(){
        JFrame frame = new JFrame("Регистрация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("ФИО");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Логин");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Пароль");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l3.setForeground(Color.blue);
        l3.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t3 = new JTextField(10);
        t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t3.setForeground(Color.blue);
        t3.setAlignmentX(Component.LEFT_ALIGNMENT);
        p3.add(l3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JButton b1 = new JButton("Зарегистрироваться");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean repeat = false;
                String name = t1.getText();
                String login = t2.getText();
                for (User user : Main.Users){
                    if (user.getLogin().compareTo(login) == 0){
                        JOptionPane.showMessageDialog(null, "Этот логин уже занят");
                        repeat = true;
                        break;
                    }
                }
                if(repeat)
                    return;
                String password = t3.getText();
                User a = new User(name, login, password);
                Main.Users.add(a);
                frame.dispose();
                Menu();
            }
        });
        p4.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void Authorization(){
        JFrame frame = new JFrame("Авторизация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Логин");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Пароль");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Войти");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.currentUser = null;
                String login = t1.getText();
                String password = t2.getText();
                for (User user : Main.Users){
                    if (user.enter(login, password)){
                        Main.currentUser = user;
                    }
                }
                if (Main.currentUser == null){
                    JOptionPane.showMessageDialog(null, "Неверно введен логин или пароль");
                    frame.dispose();
                    Menu();
                    return;
                }
                if (Main.currentUser.getClass().getName().compareTo("com.company.Admin") == 0){
                    frame.dispose();
                    Admin();
                }else{
                    frame.dispose();
                    User();
                }
            }
        });
        p3.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void Admin(){
        JFrame frame = new JFrame("Админ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 400);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Список всех заявок");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b2 = new JButton("Распределить и отправить заявки");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b3 = new JButton("Удалить заявку");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton b4 = new JButton("Выход");
        b4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b4.setForeground(Color.blue);
        b4.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] tables = {"Имя", "Логин", "Пароль"};
        String[][] data = new String[Main.Users.size()][3];
        int i = 0;
        for (User u : Main.Users){
            data[i][0] = u.getName();
            data[i][1] = u.getLogin();
            data[i][2] = u.getPassword();
            i++;
        }
        JTable t = new JTable(data, tables);
        t.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t.setForeground(Color.blue);
        t.setAlignmentX(Component.LEFT_ALIGNMENT);
        t.setPreferredScrollableViewportSize(t.getPreferredSize());
        t.setFillsViewportHeight(true);
        JScrollPane sp = new JScrollPane(t);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allreq();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Request r: Main.employerRequest) {
                    for (Request req : Main.workerRequests) {
                        if (srav(req, r) == 2) {
                            req.getRequester().takeResult(r);
                        }
                    }
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Request req = new Request();
               clearWorkerRequests(req.getRequester());
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });


        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(sp);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void User(){
        JFrame frame = new JFrame("Пользователь");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Сформировать заявку");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b2 = new JButton("Результаты заявки");
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b2.setForeground(Color.blue);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton b3 = new JButton("Выход");
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b3.setForeground(Color.blue);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createReq();
                frame.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu();
            }
        });


        panel.add(b1);
        panel.add(b2);
        panel.add(b3);


        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void createReq(){
        JFrame frame = new JFrame("Заявка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 400);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Введите должность");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l1.setForeground(Color.blue);
        l1.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t1 = new JTextField(10);
        t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t1.setForeground(Color.blue);
        t1.setAlignmentX(Component.LEFT_ALIGNMENT);
        p1.add(l1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Введите зарплату");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l2.setForeground(Color.blue);
        l2.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t2 = new JTextField(10);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t2.setForeground(Color.blue);
        t2.setAlignmentX(Component.LEFT_ALIGNMENT);
        p2.add(l2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Введите вермя работы");
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l3.setForeground(Color.blue);
        l3.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t3 = new JTextField(10);
        t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t3.setForeground(Color.blue);
        t3.setAlignmentX(Component.LEFT_ALIGNMENT);
        p3.add(l3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JLabel l4 = new JLabel("Вы работодатель/работник");
        l4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        l4.setForeground(Color.blue);
        l4.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField t4 = new JTextField(10);
        t4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        t4.setForeground(Color.blue);
        t4.setAlignmentX(Component.LEFT_ALIGNMENT);
        p4.add(l4);
        p4.add(t4);

        JPanel p5 = new JPanel();
        JButton b1 = new JButton("Отправить");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Request r = new Request();
                String type = "Работник";
                r.setType(type);
                if (type == t4.getText()){
                    if(type == "Работник") {
                        Main.workerRequests.add(r);
                    }else{
                        type = "Работодатель";
                        Main.employerRequest.add(r);
                        }
                }
                frame.dispose();
                User();
            }
        });
        p5.add(b1);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p5);

        frame.add(panel);

        frame.setVisible(true);
    }



    public void allreq(){
        JFrame frame = new JFrame("Все заявки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 400);

        JPanel panel = new JPanel();

        String[] tables = {"Логин","Работа", "Зарплата", "Рабочий день","Кто?"};
        String[][] work = new String[Main.workerRequests.size()][4];
        String[][] name = new String[Main.Users.size()][2];
        String[][] emp = new String[Main.employerRequest.size()][4];

        int i = 0;
        int k = 0;

        for (Request r : Main.workerRequests ){
            work[i][0] = r.getJob();
            work[i][1] = String.valueOf(r.getPayment());
            work[i][2] = String.valueOf(r.getHoursInWork());
            work[i][3] = r.getType();

            i++;
        }

        for (Request req : Main.employerRequest){
            emp[k][0] = req.getJob();
            emp[k][1] = String.valueOf(req.getPayment());
            emp[k][2] = String.valueOf(req.getHoursInWork());
            emp[k][3] = req.getType();
            k++;
        }
        JTable tw = new JTable(work, tables);
        tw.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tw.setForeground(Color.blue);
        tw.setAlignmentX(Component.LEFT_ALIGNMENT);
        tw.setPreferredScrollableViewportSize(tw.getPreferredSize());
        tw.setFillsViewportHeight(true);
        JScrollPane sw = new JScrollPane(tw);

        JTable te = new JTable(emp, tables);
        te.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        te.setForeground(Color.blue);
        te.setAlignmentX(Component.LEFT_ALIGNMENT);
        te.setPreferredScrollableViewportSize(te.getPreferredSize());
        te.setFillsViewportHeight(true);
        JScrollPane se = new JScrollPane(te);

        JButton b1 = new JButton("Выход");
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        b1.setForeground(Color.blue);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Admin();
            }
        });


        panel.add(b1);
        panel.add(sw);
        panel.add(se);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }





    private void clearWorkerRequests(Client worker) {
        Main.workerRequests.removeIf(r -> r.getRequester().equals(worker));
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
