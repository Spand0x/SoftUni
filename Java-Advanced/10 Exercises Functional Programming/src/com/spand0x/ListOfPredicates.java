package com.spand0x;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer,Integer> isDivisible = (e1,e2)->e1%e2==0;
        for(int i = 1; i <= n; i++){
            boolean check = true;
            for (int number : arr) {
                if(!isDivisible.test(i,number)){
                    check = false;
                }
            }
            if(check){
                System.out.print(i + " ");
            }
        }
    }
}
