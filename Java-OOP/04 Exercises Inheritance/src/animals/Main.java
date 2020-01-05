package animals;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animals = new LinkedList<>();

        while (!"Beast!".equalsIgnoreCase(input)) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            String gender;
            Animal animal;
            try {
                switch (input) {
                    case "Dog":
                        gender = line[2];
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        gender = line[2];
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        gender = line[2];
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                    default:
                        animal = new Tomcat(name, age);
                        break;
                }
                animals.add(animal);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input");
            }
            input = scanner.nextLine();
        }
        for (Animal animal:animals) {
            System.out.println(animal.toString());
//            System.out.println(animal.produceSound());
        }
    }
}
