package com.spand0x;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("&");
        List<String> validKeys = new LinkedList<>();
        List<String> finalKeys = new LinkedList<>();
        for(int i = 0; i<input.length; i++){
            if(input[i].length()==16 || input[i].length()==25){
                Pattern pattern = Pattern.compile("^[\\d\\w]+$");
                Matcher matcher = pattern.matcher(input[i]);
                if (matcher.find()){
                    validKeys.add(input[i]);
                }
            }
        }

        for (String key : validKeys) {
            StringBuilder sb = new StringBuilder();
            if(key.length() == 16){
                sb.append(key,0,4);
                for(int i = 4; i < 16; i+=4){
                    //System.out.println(i);
                    sb.append("-");
                    sb.append(key,i, i+4);
                    //System.out.println(sb.toString());
                }
            }else if(key.length() == 25){
                sb.append(key,0,5);
                for(int i = 5; i < 25; i+=5){
                    //System.out.println(i);
                    sb.append("-");
                    sb.append(key,i, i+5);
                    //System.out.println(sb.toString());
                }
            }
            char[] last = sb.toString().toCharArray();
            for(int i = 0; i < last.length; i++){
                char temp = last[i];
                if(Character.isDigit(temp)){
                    int digit = Integer.parseInt(String.valueOf(temp));
                    int newDigit = 9-(char)(digit);
                    last[i] = (char)(newDigit+48);
                }else if(Character.isLetter(temp)){
                    last[i] = Character.toUpperCase(temp);
                }
            }

            finalKeys.add(new String(last));

        }

        System.out.println(finalKeys.toString().replaceAll("[\\[\\]]",""));


    }
}
