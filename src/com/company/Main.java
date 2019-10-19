package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,
                num = 0;

        Array arr;
        while (num != 3) {
            Scanner in = new Scanner(java.lang.System.in);

            System.out.println("\n" + "Как вы хотите ввести массив");
            System.out.println("1. Датчиком случайных чисел");
            System.out.println("2. Ввод с клавиатуры");
            System.out.println("3. Exit");
            System.out.println("Выберите объект");
            num = in.nextInt();
            switch (num) {
                case 1:
                    testArray1();
                    break;
                case 2:
                    Write1();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void testArray1() {
        int n = 0;
        Scanner in = new Scanner(java.lang.System.in);
        try {
            System.out.println(" Введите количество элементов массива ");
            n = in.nextInt();
            Array array = new Array(n);
            array.randInput(20,0);
            array.consolOuput();
            array.cratnost();
            array.shestn();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void Write1() {
        int size;
        Scanner in = new Scanner(java.lang.System.in);
        try {
            System.out.println("Введите размер массива ");
            size = in.nextInt();
            Array array = new Array(size);
            array.write();
            array.cratnoct2();
            array.shestn2();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
