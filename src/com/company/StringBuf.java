package com.company;

public class StringBuf {
        private String text;
        private StringBuilder izmen = new StringBuilder();
        private StringBuilder Sum = new StringBuilder();
        private StringBuilder newChisl = new StringBuilder();

        StringBuf(String t) {
            text = t;
        }
    public StringBuilder izmenstroki() {
        izmen.setLength(0);
        double digit = 0;
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                izmen.append(String.format("%.2f", digit));
            } catch(NumberFormatException e) {
                izmen.append(word);
            }
            izmen.append(" ");
        }
        return izmen;
    }
    public StringBuilder naxochdSum() {
        double digit = 0;
        Sum.setLength(0);
        double res = 0;
        Sum.append(text).append(" ");
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                res += digit;
            } catch (NumberFormatException e) {
            }
        }
        return Sum.append(res);
    }
    public StringBuilder nowchisl() {
        int counter = 1;
        double max = -922337203685477580.0d;
        double digit = 0;
        newChisl.setLength(0);
        for (String word : text.split(" ")) {
            try {
                digit = Double.parseDouble(word);
                if (digit > max){
                    max = digit;
                    newChisl.append(counter).append(" Нов.числ) ").append(word);
                    counter++;
                }
                else
                    newChisl.append(word);
            } catch(NumberFormatException e) {
                newChisl.append(word);
            }
            newChisl.append(" ");
        }
        return newChisl;
    }


    }
