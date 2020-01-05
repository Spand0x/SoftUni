package spand0x;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println(new DecimalFormat("0.####").format(calculate(a,operator,b)));

    }

    public static double calculate(int a, char operator, int b){
        switch (operator){
            case '/':
                return (double)(a/b);
            case '*':
                return (a*b);
            case '+':
                return a+b;
            case '-':
                return a-b;
        }
        return -1;
    }

}
