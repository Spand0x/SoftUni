package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '('){
                indexes.push(i);
            }else if(ch == ')'){
                int startIndex = indexes.pop();
                String expresion = input.substring(startIndex,i+1);
                System.out.println(expresion);
            }
        }

    }
}
