package spand0x;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        printGrade(n);
    }
    public static void printGrade(double n){
        if(n>=5.50){
            System.out.println("Excellent");
        }else if(n>=4.50){
            System.out.println("Very good");
        }else if(n>=3.50){
            System.out.println("Good");
        }else if(n>=3.00){
            System.out.println("Poor");
        }else{
            System.out.println("Fail");
        }
    }
}
