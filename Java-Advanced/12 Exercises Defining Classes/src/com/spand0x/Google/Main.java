package com.spand0x.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Set<Person> people = new HashSet<>();
        while (!"End".equalsIgnoreCase(input[0])){
            String name = input[0];
            Person currentPerson = findPerson(people,name);
            String category = input[1];
            switch (category){
                case "company":
                    currentPerson.setCompany(new Company(input[2],input[3],Double.parseDouble(input[4])));
                    break;
                case "pokemon":
                    currentPerson.addPokemon(new Pokemon(input[2],input[3]));
                    break;
                case "parents":
                    currentPerson.addParent(new Parent(input[2],input[3]));
                    break;
                case "children":
                    currentPerson.addChild(new Children(input[2],input[3]));
                    break;
                case "car":
                    currentPerson.setCar(new Car(input[2],Integer.parseInt(input[3])));
                    break;
            }
            people.add(currentPerson);

            input = scanner.nextLine().split("\\s+");
        }
        String findName = scanner.nextLine();
        Person current = null;
        for (Person person:people) {
            if(person.getName().equalsIgnoreCase(findName)){
                current = person;
            }
        }
        System.out.println(current.toString());
    }

    public static Person findPerson(Set<Person> people, String name){
        for (Person person : people) {
            if(person.getName().equalsIgnoreCase(name)){
                return person;
            }
        }
        return new Person(name);
    }
}
