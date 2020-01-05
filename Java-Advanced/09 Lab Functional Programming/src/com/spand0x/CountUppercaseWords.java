package com.spand0x;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<String> uppercase = new LinkedList<>();
        int count = 0;
        Predicate<String> checkCase = word -> Character.isUpperCase(word.charAt(0));
        for (String word :
                input) {
            if(checkCase.test(word)){
                count++;
                uppercase.add(word);
            }
        }
        System.out.println(count);
        for (String word : uppercase) {
            System.out.println(word);
        }
    }
}
