package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Array {
    private int n;
    private long [] x;
    private static int size1;
    private static long[] array2;

    Array(int n) throws Exception
    {
        if (n < 0) throw new Exception(new String(" Количество элементов <= 0 "));
        this.n = n;
        this.x = new long[this.n];

    }
    void randInput( long max,long min) {
        for (int i = 0; i < n; i++) {
            x[i] = (long) (Math.random() * (max+min+1))-min;
        }
    }

    void consolOuput() {
        java.lang.System.out.println("Массив Чисел");
        for (int i = 0; i < n; i++) {
            java.lang.System.out.print(" " + x[i]);
        }
        System.out.println("\nЭлементы в обратном порядке");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(" " + x[i]);
        }
        System.out.print("\n");
    }
    void cratnost() {
        Scanner input = new Scanner(System.in);
        long b;
        System.out.println("Введите положительное целое число отличное от нуля для проверки кратности: ");
        int kr = input.nextInt();
        System.out.println("Введено число: " + kr);

        for (int i = 0; i < n; i++) {
            if (x[i] % kr == 0) {
                System.out.println("Кратный элемент массива: " + x[i]);
                String temp = "";
                long emp = x[i];
                while (emp != 0) {
                    b = emp % 2;
                    temp = b + temp;
                    emp = emp / 2;
                }
                System.out.println("Двоичное представление : " + temp);
            }
        }
    }
        void shestn() {
            long maxim = 0;
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (maxim <= Math.abs(x[i])) {
                    maxim = Math.abs(x[i]);
                    p = i;
                }
            }
            System.out.println("Модуль самого длинного числа в шестнадцаетричном представлении: " + maxim);
            System.out.println("Индекс числа: " + p);
        }


    public void write() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива повторно для точности : ");
        int size = input.nextInt();
        size1=size;
        long array[] = new long[size1];
        System.out.println("Заполните массив:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.print("Заполненный массив: \n");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println("\nЭлементы в обратном порядке: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(" " + array[i]);
        }
        System.out.print("\n");
        array2= (array);
    }

    public static void cratnoct2() {

        Scanner input = new Scanner(System.in);
             System.out.println("Введите положительное целое число отличное от нул для проверки кратности: ");
             int kr = input.nextInt();
             System.out.println("Введено число: " + kr);
             for (int i = 0; i < size1; i++) {
                 if (array2[i] % kr == 0) {
                     System.out.println("Кратный элемент массива: " + array2[i]);
                     long b;
                     String temp = "";
                     while (array2[i] != 0) {
                         b = array2[i] % 2;
                         temp = b + temp;
                         array2[i] = array2[i] / 2;
                     }
                     System.out.println("Двоичное представление : " + temp);
                 }
             }
         }
    public static void shestn2() {
        long max = 0;
        int maxc= 0 ;
        int p = 0;
        for (int i = 0; i < size1; i++) {
            if (maxc < Long.toHexString(array2[i]).length()){
                max = array2[i];
                maxc = Long.toHexString(array2[i]).length();
                p = i;
            }
        }
        System.out.println("Cамое длинное число в шестнадцаетричном представлении: " + max);
        System.out.println("Индекс числа: " + p);
    }
    }
