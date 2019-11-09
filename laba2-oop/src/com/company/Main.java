package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String text = in.nextLine();

        Stroky str = new Stroky(text);
        StringBuf str1 = new StringBuf(text);
        Regularn str2= new Regularn(text);
        int num = 0;
        while (num != 3) {
            System.out.println("\n");
            System.out.println("Введите номер задания: ");
            num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Макс. число: " + str.naxojdmax());
                    System.out.println("Точность 2 знака после запятой:" + str.izmstroky());
                    System.out.println("Строка прописных :"+ str.prop());
                    System.out.print("Введите символ: ");
                    text = in.next();
                    char simv = text.toCharArray()[0];
                    System.out.println("Количество слов начинающихся с символа " +  simv + " : " + str.skolkoslov(simv));
                    break;
                case 2:
                    System.out.println("Точность 2 знака после запятой:" + str1.izmenstroki());
                    System.out.println("Сумма чисел в формате с плавающей точкой: "+str1.naxochdSum() );
                    System.out.println("Новые числа перед каждым наибольшим: "+ str1.nowchisl());
                    break;
                case 3:
                    if(str2.IPV6()){
                        System.out.println("Соответствует");
                    }
                    else{
                        System.out.println("Не соответствует");
                        System.out.println(str2.replace());
                    }
                    break;
                default:
                    System.out.println("Номер задания выбран неверно, повторите ввод");
            }
        }
    }
}
