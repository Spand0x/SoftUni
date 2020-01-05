package com.spand0x;

import java.util.*;
import java.util.regex.Pattern;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> chemicalLiquids = new ArrayDeque<>(); //queue
        for (int number : input) {
            chemicalLiquids.add(number);
        }
        input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> physical = new ArrayDeque<>(); //stack
        for (int number: input) {
            physical.push(number);
        }
        Map<String,Integer> materialAndCount = fillMatAndCount();
        while(!chemicalLiquids.isEmpty() && !physical.isEmpty()){
            int firstLiquid = chemicalLiquids.removeFirst();
            int lastPhysical = physical.removeFirst();
            int sum = firstLiquid+lastPhysical;
            switch (sum){
                case 25:
                    materialAndCount.put("Glass",materialAndCount.get("Glass")+1);
                    break;
                case 50:
                    materialAndCount.put("Aluminium",materialAndCount.get("Aluminium")+1);
                    break;
                case 75:
                    materialAndCount.put("Lithium",materialAndCount.get("Lithium")+1);
                    break;
                case 100:
                    materialAndCount.put("Carbon fiber",materialAndCount.get("Carbon fiber")+1);
                    break;
                default:
                    physical.addFirst(lastPhysical+3);

                    break;
            }
        }
        boolean isBuild = true;
        for (String material: materialAndCount.keySet()) {
            int value = materialAndCount.get(material);
            if(value<1){
                isBuild = false;
                break;
            }
        }

        if(isBuild){
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if(chemicalLiquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + chemicalLiquids.toString().replaceAll("[\\[\\]]",""));
        }

        if(physical.isEmpty()){
            System.out.println("Physical items left: none");
        }else {
            System.out.println("Physical items left: " + physical.toString().replaceAll("[\\[\\]]",""));
        }
        materialAndCount.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static Map<String, Integer> fillMatAndCount() {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("Aluminium",0);
        map.put("Carbon fiber", 0);
        map.put("Glass",0);
        map.put("Lithium", 0);
        return map;
    }
}
