package com.company;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Regularn {
    Pattern pattern = Pattern.compile("[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}");
    String text;
    String eight;
    Regularn(String text){
        this.text = text;
    }
    public boolean IPV6(){
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    public String replace(){
        Matcher matcher = pattern.matcher(text);
        String[] Sixteen;
        String[] withoutIP = pattern.split(text);
        StringBuilder result;
        eight = text;
        int count = 0;
        while(matcher.find()) {
            String IP = matcher.group();
            Sixteen = IP.split(":");
            StringBuilder ip = new StringBuilder();
            int num;
            for(int i = 0; i<7; i++){
                Sixteen[i] = "0x"+Sixteen[i];
                num = Integer.decode(Sixteen[i]);
                String convert = Integer.toOctalString(num);
                ip.append(convert).append(":");
            }
            Sixteen[7] = "0x"+Sixteen[7];
            num = Integer.decode(Sixteen[7]);
            String convert = Integer.toOctalString(num);
            ip.append(convert);
            eight = eight.replaceAll(IP, ip.toString());
        }
        return eight;
    }
}

