package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if(decimal == 0){
            System.out.println(0);
        }
        while(decimal!=0){
            int leftOver = decimal % 2;
            binary.push(leftOver);
            decimal /= 2;
        }
        for (int number :
                binary) {
            System.out.print(number);
        }
    }
}
