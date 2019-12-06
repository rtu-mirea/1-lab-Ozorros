package exm;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        String name, surname, number, date, adr;
        int ch;
        while(true)
        {
            System.out.println("Ввести нового человека? (y = 1/n = 0)");
            ch = scan.nextInt();
            if(ch == 1)
            {
                scan.nextLine();
                System.out.println("Введите Имя");
                name = scan.nextLine();
                System.out.println("Введите Фамилию");
                surname = scan.nextLine();
                System.out.println("Введите номер телефона");
                number = scan.nextLine();
                System.out.println("Введите дату рождения");
                date = scan.nextLine();
                System.out.println("Введите адрес");
                adr = scan.nextLine();
                personArrayList.add(new Person(name, surname, number, date, adr));
            }
            else if(ch == 0)
            {

                break;
            }
            else
                System.out.println("Введено неверное значение");
        }
        Person[] person = personArrayList.toArray(new Person[personArrayList.size()]);
        String checkName;
        String checkSurname;
        int enterOper;
        System.out.println("Введите операцию\n1- вывести номер телефона по имени и фамилии" +
                "\n2- определить, проживают ли двое по одному адресу" +
                "\n3- Вывести людей с одинаковой фамилией, но разными именами" +
                "\n4- Заменить фамилию в записи");
        enterOper = scan.nextInt();
        if(enterOper == 1)
        {
            scan.nextLine();
            System.out.println("Введите имя");
            checkName = scan.nextLine();
            System.out.println("Введите фамилию");
            checkSurname = scan.nextLine();
            for(int i = 0; i < person.length; i++)
            {
                if(person[i].name.equals(checkName) && person[i].surname.equals(checkSurname))
                    System.out.println(person[i].number);
            }
        }
        if(enterOper == 2)
        {
            scan.nextLine();
            String checkName2;
            String checkSurname2;
            System.out.println("Введите имя 1");
            checkName = scan.nextLine();
            System.out.println("Введите фамилию 1");
            checkSurname = scan.nextLine();
            System.out.println("Введите имя 2");
            checkName2 = scan.nextLine();
            System.out.println("Введите фамилию 2");
            checkSurname2 = scan.nextLine();
            String address1 = new String();
            String address2 = new String();
            for(int i = 0; i < person.length; i++)
            {
                if(person[i].name.equals(checkName) && person[i].surname.equals(checkSurname))
                {
                    address1 = person[i].adr;
                    break;
                }
            }
            for(int i = 0; i < person.length; i++)
            {
                if(person[i].name.equals(checkName2) && person[i].surname.equals(checkSurname2))
                {
                    address2 = person[i].adr;
                    break;
                }
            }
            if(address1.equals(address2))
            {
                System.out.println("Адреса совпадают");
            }
            else
            {
                System.out.println("Адреса не совпадают");
            }
        }
        if(enterOper == 3)
        {
            System.out.println("Одинаковые фамилии имеют");
            for(int i = 0; i < person.length - 1; i++)
                for(int j = i + 1; j < person.length; j++)
                {
                    if(!person[i].name.equals(person[j].name) && person[i].surname.equals(person[j].surname))
                    {
                        System.out.println(person[i].name + " " + person[i].surname + " и " + person[j].name + " " + person[j].surname);
                    }
                }
        }
        if(enterOper == 4)
        {
            String changeSur;
            int enterPerson;
            for(int i = 0; i < person.length; i++)
            {
                System.out.println(i + ")" + person[i].name + " " + person[i].surname);
            }
            System.out.println("Выберете человека");
            enterPerson = scan.nextInt();
            scan.nextLine();
            System.out.println("Введите новую фамилию");
            changeSur = scan.nextLine();
            person[enterPerson].surname = changeSur;
            System.out.println("Новая фамилия: " + person[enterPerson].surname);
        }
    }
}
