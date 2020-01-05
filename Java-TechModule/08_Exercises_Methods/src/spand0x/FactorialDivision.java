package spand0x;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        double facA = factorial(a);
        double facB = factorial(b);
        System.out.printf("%.2f",division(facA,facB));
    }

    private static double factorial(int n){
        double result = 1;
        if(n == 0){
            return 1;
        }
        for(int i = n; i >=1; i--){
            result*=i;
        }
        return result;
    }
    private static double division(double a, double b){
        return a/b;


    }
}
