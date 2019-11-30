package com.company;
import java.util.Scanner;

public class Stroky {
        private String text;
        private String izmen;
        private String propisn;

        Stroky(String t){
                text=t;
        }


        public  String naxojdmax() {
                boolean hasFound = false;
                double max = -922337203685477580.0d;
                double digit = 0;
                for (String word : text.split(" ")) {
                        try {
                                digit = Double.parseDouble(word);
                                if (digit > max)
                                        max = digit;
                                        hasFound = true;
                        } catch(NumberFormatException e) {
                                hasFound = false;
                        }
                }

                if(!hasFound ) return null;
                return Double.toString(max);
        }
        public String izmstroky(){

                double digit = 0;
                izmen = "";
                for (String word : text.split(" ")) {
                        try {
                                digit = Double.parseDouble(word);
                                izmen += " " + String.format("%.2f", digit);
                        } catch(NumberFormatException e) {
                                izmen += " " + word;
                        }
                }
                return izmen;
        }
        public String prop() {
                double digit = 0;
                propisn = "";
                String[] words =  text.split(" ");
                for (int i = 0; i < words.length-1; i++) {
                        try {
                                digit = Double.parseDouble(words[i+1]); //Если предыдущее слово тоже цифра
                                try {
                                        digit = Double.parseDouble(words[i]);
                                } catch(NumberFormatException e) {
                                        propisn += " " + words[i].toUpperCase();
                                }
                        } catch(NumberFormatException e) {
                        }
                }
                return propisn;
        }
        public String skolkoslov(char simv)
        {
                int counter = 0;
                for (String word : text.split(" ")) {
                        if (word.startsWith(String.valueOf(simv)))
                                counter++;
                }
                return Integer.toString(counter);
        }
        }


