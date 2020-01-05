package spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> nameAndPrice = new LinkedHashMap<>();
        Map<String, Integer> nameAndQuantity = new LinkedHashMap<>();
        //Map<String, Integer> result = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" ");
        while (!"buy".equalsIgnoreCase(input[0])){
            String name = input[0];
            double price = Double.parseDouble(input[1]);
            int quantity = Integer.parseInt(input[2]);
            if(nameAndQuantity.containsKey(name)){
                nameAndQuantity.put(name, nameAndQuantity.get(name)+quantity);
                if(nameAndPrice.get(name) != price){
                    nameAndPrice.put(name,price);
                }
            }else{
                nameAndPrice.put(name, price);
                nameAndQuantity.put(name, quantity);
            }


            input = scanner.nextLine().split(" ");
        }
        for (String name : nameAndPrice.keySet()){
            int quantity = nameAndQuantity.get(name);
            double price = nameAndPrice.get(name);
            double total = price * quantity;
            System.out.printf("%s -> %.2f\n", name,total);
        }
    }
}
