package com.spand0x;

import java.util.Scanner;

public class CookingMasterclass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        int freePackage = students/5;
        double apronTotal = apronPrice * Math.ceil(students + (students * 0.2));
        double eggTotal = 10 * eggPrice * students;
        double flourTotal = flourPrice * (students - freePackage);
        double totalPrice = apronTotal + eggTotal + flourTotal;
        if(budget>=totalPrice){
            System.out.printf("Items purchased for %.2f$.",totalPrice);
        }else{
            double needed = totalPrice-budget;
            System.out.printf("%.2f$ more needed.",needed);
        }
    }
}
