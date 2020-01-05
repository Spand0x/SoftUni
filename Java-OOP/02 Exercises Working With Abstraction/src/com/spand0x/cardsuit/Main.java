package com.spand0x.cardsuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Cards[] cards = Cards.values();
        System.out.println("Card Suits:");
        for (int i = 0; i < 4; i++) {
            Cards card = Cards.valueOf(cards[i].toString());
            System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card);
        }

    }
}
