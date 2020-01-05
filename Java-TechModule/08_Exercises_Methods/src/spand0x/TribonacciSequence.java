package spand0x;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            System.out.print(getFibonacci(i) + " ");
        }
    }
    public static int getFibonacci(int n){
        int nMinusOne = 0;
        int nMinusTwo;
        int nMinusThree;
        if(n == 0){
            return 1;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        else {
            nMinusOne = getFibonacci(n - 1);
            nMinusTwo = getFibonacci(n - 2);
            nMinusThree = getFibonacci(n - 3);
        }
        return nMinusOne+nMinusTwo+nMinusThree;

    }

}
