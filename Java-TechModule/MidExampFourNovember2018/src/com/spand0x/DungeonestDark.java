package com.spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int coins = 0;
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        for (int i = 0; i < rooms.size(); i ++) {
            String[] inTheRoom = rooms.get(i).split(" ");
            String itemOrMonster = inTheRoom[0];
            int number = Integer.parseInt(inTheRoom[1]);
            switch (itemOrMonster) {
                case "potion":
                    if (health + number >= 100) {
                        int healed = 100 - health;
                        System.out.println("You healed for " + healed + " hp.");
                        health = 100;
                    } else {
                        health = health + number;
                        System.out.println("You healed for " + number + " hp.");
                    }
                    System.out.println("Current health: " + health + " hp.");
                    break;
                case "chest":
                    coins += number;
                    System.out.println("You found " + number + " coins.");
                    break;
                default:
                    if(health-number<=0){
                        System.out.println("You died! Killed by " + itemOrMonster + ".");
                        System.out.println("Best room: " + (i+1));
                        return;
                    }else{
                        health-=number;
                        System.out.println("You slayed " + itemOrMonster + ".");
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.println("Coins: " + coins);
        System.out.println("Health: " + health);
    }
}
