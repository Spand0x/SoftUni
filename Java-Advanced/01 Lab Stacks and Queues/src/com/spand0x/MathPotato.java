package com.spand0x;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        for (String kid :
                input) {
            kids.offer(kid);
        }
        int count = 1;
        while (kids.size() > 1){

            for(int i = 1; i < n; i++){
                kids.offer(kids.poll());
            }
            if(isPrime(count)) {
                System.out.println("Prime " + kids.peek());
            }else {
                System.out.println("Removed " + kids.poll());
            }
            count++;
        }
        System.out.println("Last is " + kids.poll());

    }

    public static boolean isPrime(int number){
        if(number==1){
            return false;
        }
        for(int i = 2; i < number; i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
