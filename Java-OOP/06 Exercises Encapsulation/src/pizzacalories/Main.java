package pizzacalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split("\\s+");
        String pizzaName = line1[1];
        int numberOfToppings = Integer.parseInt(line1[2]);
        String[] line2 = scanner.nextLine().split("\\s+");
        String doughFlour = line2[1];
        String doughBaking = line2[2];
        double doughWeight = Double.parseDouble(line2[3]);
        String[] input = scanner.nextLine().split("\\s+");
        Pizza pizza = null;
        Dough dough = null;
        try{
            pizza = new Pizza(pizzaName,numberOfToppings);
            dough = new Dough(doughFlour,doughBaking,doughWeight);
            pizza.setDough(dough);
            int count = 0;
            while (!"END".equalsIgnoreCase(input[0]) && count<10){
                String toppingType = input[1];
                double toppingWeight = Double.parseDouble(input[2]);
                try{
                    Topping topping = new Topping(toppingType,toppingWeight);
                    pizza.addTopping(topping);
                    count++;
                    input = scanner.nextLine().split("\\s+");
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                    return;
                }

            }
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }




    }
}
