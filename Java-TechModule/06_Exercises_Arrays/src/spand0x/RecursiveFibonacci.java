package spand0x;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(n));
    }

    public static int getFibonacci(int n){
       int nMinusOne = 0;
       int nMinusTwo;
       if(n == 1){
           return 1;
       }else if(n==0){
           return 0;
       }
       else {
           nMinusOne = getFibonacci(n - 1);
           nMinusTwo = getFibonacci(n - 2);
       }
       return nMinusOne+nMinusTwo;

    }
}
