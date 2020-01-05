package spand0x;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (input){
            case "add":
                addNumbers(a,b);
                break;
            case "multiply":
                multiplyNumbers(a,b);
                break;
            case "divide":
                divideNumbers(a,b);
                break;
            case "subtract":
                subtractNumbers(a,b);{
                break;

            }
        }
    }
    private static void addNumbers(int a, int b) {
        System.out.println(a+b);
    }

    private static void multiplyNumbers(int a, int b) {
        System.out.println(a*b);
    }

    private static void divideNumbers(int a, int b) {
        System.out.println(a/b);
    }

    private static void subtractNumbers(int a, int b) {
        System.out.println(a-b);
    }
}
