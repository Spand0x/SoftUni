package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        for(int i = 0; i < input.length; i++){
            if(!Character.isDigit(input[i].charAt(0))){
                char sumOrMin = input[i].charAt(0);
                int result = 0;
                if (sumOrMin == '+') {
                    result = numbers.pop() + Integer.parseInt(input[i+1]);
                }else {
                    result = numbers.pop() - Integer.parseInt(input[i+1]);
                }
                i++;
                numbers.add(result);
            }else{
                Integer number = Integer.parseInt(input[i]);
                numbers.add(number);
            }
        }
        System.out.println(numbers.peek());

    }
}
