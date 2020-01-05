package com.spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        Map<String, Map<String,Double>> shopProducts = new TreeMap<>();
        while (!input[0].equalsIgnoreCase("revision")){
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);
            if(!shopProducts.containsKey(shop)){
                shopProducts.put(shop,new LinkedHashMap<>());
            }
            shopProducts.get(shop).put(product,price);
            input = scanner.nextLine().split(", ");
        }
        shopProducts.entrySet().stream().forEach(x -> {
            System.out.println(x.getKey() + "->");
            x.getValue().entrySet().stream().forEach(y ->{
                System.out.printf("Product: %s, Price: %.1f\n",y.getKey(),y.getValue());
            });

        });
    }
}
