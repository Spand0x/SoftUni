package spand0x;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int sum = sumNumbers(a,b);
        System.out.println(substract(sum,c));
    }
    private static int sumNumbers(int a, int b){
        return a+b;
    }

    private static int substract(int sum,int c){
        return sum-c;
    }
}
