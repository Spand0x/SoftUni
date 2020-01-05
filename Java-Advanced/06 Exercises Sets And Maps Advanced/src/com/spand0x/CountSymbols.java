package com.spand0x;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] line = scanner.nextLine().toCharArray();
        Map<Character, Integer> charCount = new TreeMap<>();
        for (int i = 0; i < line.length; i++) {
            if(!charCount.containsKey(line[i])){
                charCount.put(line[i],1);
            }else {
                charCount.put(line[i],charCount.get(line[i])+1);
            }
        }
        for (char symbol :
                charCount.keySet()) {
            System.out.printf("%s: %d time/s\n",symbol,charCount.get(symbol));
        }

    }
}
