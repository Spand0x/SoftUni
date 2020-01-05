package com.spand0x;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> reservation = new TreeSet<>();
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("party")){
            reservation.add(input);
            input = scanner.nextLine();
        }
        while (!input.equalsIgnoreCase("end")){
            reservation.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(reservation.size());
        reservation.forEach(System.out::println);
    }
}
