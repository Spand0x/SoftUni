package com.spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> quests = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" - ");
        while (!"Retire!".equals(input[0])) {
            switch (input[0]) {
                case "Start":
                    if (!quests.contains(input[1])) {
                        quests.add(input[1]);
                    }
                    break;
                case "Complete":
                    quests.remove(input[1]);
                    break;
                case "Side Quest":
                    String[] questAndSide = input[1].split(":");
                    String quest = questAndSide[0];
                    String side = questAndSide[1];
                    if(quests.contains(quest)){
                        if(!quests.contains(side)){
                            int index = quests.indexOf(quest);
                            quests.add(index+1,side);
                        }
                    }
                    break;
                case "Renew":
                    if(quests.contains(input[1])){
                        quests.remove(input[1]);
                        quests.add(input[1]);
                    }
                    break;

            }

            input = scanner.nextLine().split(" - ");
        }
        System.out.println(quests.toString().replaceAll("[\\[\\]]","").trim());
    }
}
