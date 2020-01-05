package spand0x;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String input = scanner.nextLine();
        switch (type){
            case "int":
                printResult(Integer.parseInt(input));
                break;
            case "real":
                printResult(Double.parseDouble(input));
                break;
            case "string":
                printResult(input);
                break;
        }
    }
    private static void printResult(int number){
        System.out.println(number*2);
    }
    private static void printResult(double real){
        System.out.printf("%.2f", (real*1.5));
    }
    private static void printResult(String input){
        System.out.println("$" + input + "$");
    }
}
