package com.spand0x.cardswithpower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRank = scanner.nextLine();
        String inputSuit = scanner.nextLine();
        Rank rank = Rank.valueOf(inputRank);
        Suits suit = Suits.valueOf(inputSuit);
        System.out.printf("Card name: %s of %s; Card power: %d",rank,suit,rank.getValue()+suit.getValue());
    }
}
