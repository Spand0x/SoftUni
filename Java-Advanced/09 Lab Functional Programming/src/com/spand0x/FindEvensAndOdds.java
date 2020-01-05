package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensAndOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = input[0];
        int upperBound = input[1];
        String command = scanner.nextLine();
        Predicate<Integer> checkEven = createCheck(command);
        print(lowerBound,upperBound,checkEven);
    }

    private static void print(int lowerBound, int upperBound, Predicate<Integer> checkEven) {
        for(int i = lowerBound; i<=upperBound ; i++){
            if(checkEven.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createCheck(String command) {
        Predicate<Integer> check = null;
        if(command.equalsIgnoreCase("even")){
            check = x->x%2==0;
        }else{
            check = x->x%2!=0;
        }
        return check;
    }
}
