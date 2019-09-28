package com.company;
import java.util.Scanner;
import java.lang.Math;
public class Array {
    private int n;
    private long [] x;

    Array(int n)  {
        this.n = n;
        this.x = new long[this.n];
    }

    void randInput( long max,long min) {
        for (int i = 0; i < n; i++) {
            x[i] = ( long) (Math.random() * (min+max+1))-max;
        }
    }

    void consolOuput() {
        java.lang.System.out.println("Массив Чисел");
        for (int i = 0; i < n; i++) {
            java.lang.System.out.print(" " + x[i]);
        }
        System.out.println("\nЭлементы в обратном порядке");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print( " " + x[i]);
        }
        System.out.print("\n");
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
                while(emp !=0){
                    b = emp % 2;
                    temp = b + temp;
                    emp = emp /2;
                } System.out.println("Двоичное представление : "+ temp);
            }
        }
        long maxim = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (maxim <=  Math.abs(x[i])){
                maxim = Math.abs(x[i]);
                p=i;
            }
        }
        System.out.println("Модуль самого длинного числа в шестнадцаетричном представлении: "+ maxim );
        System.out.println("Индекс числа: "+ p);
    }

    static void Write() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива : ");
        int size = input.nextInt();
        long array[] = new long[size];
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
        System.out.println("Введите положительное целое число отличное от нул для проверки кратности: ");
        int kr = input.nextInt();
        System.out.println("Введено число: " + kr);
        for (int i = 0; i < size; i++) {
            if (array[i] % kr == 0) {
                System.out.println("Кратный элемент массива: " + array[i]);
                long b;
                String temp = "";
                while(array[i] !=0){
                    b = array[i] % 2;
                    temp = b + temp;
                    array[i] = array[i] /2;
                } System.out.println("Двоичное представление : "+ temp);
            }
        }

            long maximum = 0;
            int p = 0;
            for (int i = 0; i < size; i++) {
                if (maximum <= Math.abs(array[i])) {
                    maximum = Math.abs(array[i]);
                    p = i;
                }

        }
        System.out.println("Модуль самого длинное числа в шестнадцаетричном представлении: "+ maximum );
        System.out.println("Индекс числа: "+ p);
        }
    }
