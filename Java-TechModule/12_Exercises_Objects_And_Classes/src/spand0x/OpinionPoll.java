package spand0x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            personList.add(person);
        }
        List<Person> result = personList.stream().filter(person -> person.getAge()>30).sorted((Comparator.comparing(Person::getName))).collect(Collectors.toList());
        result.forEach(element -> System.out.println(element.getName() + " - " + element.getAge()));
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
