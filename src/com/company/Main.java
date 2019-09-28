package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,
                num = 0;

        Array arr;
        while (num != 3) {
            Scanner in = new Scanner(java.lang.System.in);

            java.lang.System.out.println("\n" + "Как вы хотите ввести массив");
            java.lang.System.out.println("1. Датчиком случайных чисел");
            java.lang.System.out.println("2. Ввод с клавиатуры");
            java.lang.System.out.println("3. Exit");
            java.lang.System.out.println("Выберите объект");
            num = in.nextInt();
            switch (num) {
                case 1:
                    testArray1();
                    break;
                case 2:
                    Array.Write();
                    ;
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void testArray1() {
        int n;
        Scanner in = new Scanner(java.lang.System.in);
        try {
            java.lang.System.out.println(" Введите количество элементов массива ");
            n = in.nextInt();
            Array array = new Array(n);
            array.randInput(1000,1000);
            array.consolOuput();
        } catch (Exception e) {
            java.lang.System.out.println(e.toString());
        }
    }
    public static void Write() {
        int n;
        Scanner in = new Scanner(java.lang.System.in);
        try {
            n = in.nextInt();
            Array array = new Array(n);
            array.Write();
        } catch (Exception e) {
            java.lang.System.out.println(e.toString());
        }
    }
}
