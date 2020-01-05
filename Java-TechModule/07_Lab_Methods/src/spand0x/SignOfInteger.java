package spand0x;

import java.util.Scanner;

public class SignOfInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        signOfInteger(n);
    }
    public static void signOfInteger(int n){
        if(n>0){
            System.out.println("The number " + n + " is positive.");
        }else if(n<0){
            System.out.println("The number " + n + " is negative.");
        }else{
            System.out.println("The number 0 is zero.");
        }
    }
}
