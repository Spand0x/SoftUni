package com.spand0x.cardrank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Cards[] cards = Cards.values();
        System.out.println("Card Ranks:");
        for (Cards card :
                cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",card.getValue(),card);
        }
    }
}
