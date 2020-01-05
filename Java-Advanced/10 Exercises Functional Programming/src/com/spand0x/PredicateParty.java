package com.spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String[] input = scanner.nextLine().split(" ");

        Predicate<String> checkRemove = command -> command.equalsIgnoreCase("remove");

        List<String> peopleComing = new ArrayList<>(people);
        while (!"Party!".equalsIgnoreCase(input[0])) {
            String command = input[0];
            String criteria = input[1];
            String condition = input[2];
            if (checkRemove.test(command)) { //remove
                people.removeIf(getPredicate(criteria,condition));
            } else { //double
                for (int i = 0; i < people.size(); i++) {
                    String person = people.get(i);
                    if(getPredicate(criteria,condition).test(person)){
                        people.add(person);
                        i++;
                    }
                }
            }
            input = scanner.nextLine().split(" ");
        }
        if(people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            people.sort(String::compareTo);
            System.out.print(people.toString().replaceAll("[\\[\\]]", ""));
            System.out.print(" are going to the party!");
        }
    }


    public static Predicate<String> getPredicate(String criteria, String parameter){
        switch (criteria){
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text->false;
        }
    }
}
