package com.spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(": ");
        Map<String,Integer> nameAndValue = new LinkedHashMap<>();
        while (!"JOKER".equalsIgnoreCase(input[0])){
            String name = input[0];
            String[] cards = input[1].split(", ");
            int value = 0;
            for(int i = 0; i < cards.length;i++){
                int number = Integer.parseInt(String.valueOf(cards[i].charAt(0)));
                int multiply = 1;
                switch (cards[i].charAt(1)){
                    case 'S':
                        multiply = 4;
                        break;
                    case 'H':
                        multiply = 3;
                        break;
                    case 'D':
                        multiply = 2;
                        break;
                }
                value += number*multiply;
            }
            if(!nameAndValue.containsKey(name)){
                nameAndValue.put(name,value);
            }
            nameAndValue.put(name,nameAndValue.get(name)+value);
            input = scanner.nextLine().split(": ");
        }
        for (String key :
                nameAndValue.keySet()) {
            System.out.println(key + ": " + nameAndValue.get(key));
        }
    }

}
