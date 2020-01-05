package com.spand0x;

import java.util.Scanner;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = 100;
        int initialCoins = 100;
        String[] input = scanner.nextLine().split("\\|");
        for (int i = 0; i < input.length; i++) {
            String[] action = input[i].split("-");
            switch (action[0]) {
                case "rest":
                    int newEnergy = Integer.parseInt(action[1]);
                    if(initialEnergy + newEnergy > 100){
                        System.out.println("You gained " + (100-initialEnergy) + " energy.");
                        initialEnergy = 100;
                    }else{
                        initialEnergy +=newEnergy;
                        System.out.println("You gained " + newEnergy + " energy.");
                    }
                    System.out.println("Current energy: " + initialEnergy + ".");
                    break;
                case "order":
                    if(initialEnergy>=30){
                        initialEnergy-=30;
                        initialCoins += Integer.parseInt(action[1]);
                        System.out.println("You earned " + action[1] + " coins.");
                    }else{
                        initialEnergy+=50;
                        System.out.println("You had to rest!");
                    }
                    break;
                default:

                    int price = Integer.parseInt(action[1]);
                    if(price<initialCoins){
                        initialCoins-=price;
                        System.out.println("You bought " + action[0] + ".");
                    }else{
                        System.out.println("Closed! Cannot afford " + action[0] + ".");
                        return;
                    }

                    break;

            }
        }
            System.out.println("Day completed!");
            System.out.println("Coins: " + initialCoins);
            System.out.println("Energy: " + initialEnergy);

    }
}
