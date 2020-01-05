package com.spand0x;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            if(!data.containsKey(continent)){
                data.put(continent,new LinkedHashMap<>());
                data.get(continent).put(country,new LinkedList<>());
                data.get(continent).get(country).add(city);
            }else if(!data.get(continent).containsKey(country)){
                data.get(continent).put(country, new LinkedList<>());
                data.get(continent).get(country).add(city);
            }else{
                data.get(continent).get(country).add(city);
            }
        }
        data.forEach((key1, value1) -> {
            System.out.println(key1 + ":");
            value1.forEach((key, value) -> {
                System.out.print(key + " -> ");
                String allCites = String.join(", ", value);
                System.out.println(allCites);
            });
        });
        System.out.println();
    }
}
