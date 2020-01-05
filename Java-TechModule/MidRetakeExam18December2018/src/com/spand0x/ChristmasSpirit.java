package com.spand0x;

import java.util.Scanner;

public class ChristmasSpirit {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int quantity = Integer.parseInt(scanner.nextLine());
	    int days = Integer.parseInt(scanner.nextLine());
	    int budget = 0;
	    int totalSpirit = 0;
	    for(int i = 1 ; i<=days; i++){
	        if(i%11==0){
	            quantity +=2;
            }
	        if(i%2 == 0){
	            budget += 2*quantity;
                totalSpirit+=5;
            }
            if(i%3 == 0){
                budget += (5*quantity) + (3 * quantity);
                totalSpirit += 13;
            }
            if(i%5 == 0){
                budget += 15*quantity;
                totalSpirit+=17;
                if(i%3==0){
                    totalSpirit+=30;
                }
            }
            if(i%10 == 0){
                totalSpirit -=20;
                budget += 23;
                if(days==i){
                    totalSpirit-=30;
                }
            }
        }
        System.out.println("Total cost: " + budget);
        System.out.println("Total spirit: " + totalSpirit);
    }
}
