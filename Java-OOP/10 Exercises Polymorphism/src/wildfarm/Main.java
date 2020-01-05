package wildfarm;

import wildfarm.animals.*;
import wildfarm.food.Food;
import wildfarm.food.Meat;
import wildfarm.food.Vegetable;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        List<Animal> animals = new LinkedList<>();

        while (!"End".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] animalData = input.split("\\s+");
            Animal animal = createAnimal(animalData);

            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = createFood(foodData);

            System.out.println(animal.makeSound());
            try {
                animal.eat(food);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            animals.add(animal);
        }
        for (Animal animal :
                animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] foodData) {
        Food food = null;
        String foodType = foodData[0];
        int quantity = Integer.parseInt(foodData[1]);
        if (foodType.equals("Meat")) {
            food = new Meat(quantity);
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable(quantity);
        }


        return food;
    }

    private static Animal createAnimal(String[] animalData) {
        Animal animal = null;

        String type = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String region = animalData[3];
        String breed = null;
        if (type.equalsIgnoreCase("cat")) {
            breed = animalData[4];
        }

        switch (type) {
            case "Cat":
                animal = new Cat(name, type, weight, region, breed);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, region);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, region);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, region);
                break;
        }


        return animal;
    }
}
