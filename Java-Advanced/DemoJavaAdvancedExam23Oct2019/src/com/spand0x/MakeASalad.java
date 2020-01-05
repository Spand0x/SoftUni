package com.spand0x;

import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> vegetables = new LinkedList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        List<Integer> calories = new LinkedList<>();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int cal: input) {
            calories.add(cal);
        }
        List<Integer> madeSalads = new LinkedList<>();
        int lastSalad = calories.get(calories.size()-1);
        while (!calories.isEmpty() && !vegetables.isEmpty()){
            String firstSalad = vegetables.get(0);
            int lastCalorie = calories.get(calories.size()-1);
            switch (firstSalad.toLowerCase()){
                case "tomato":
                    lastCalorie-=80;
                    break;
                case "carrot":
                    lastCalorie-=136;
                    break;
                case "lettuce":
                    lastCalorie-=109;
                    break;
                case "potato":
                    lastCalorie-=215;
                    break;

            }
            if(lastCalorie<=0){
                madeSalads.add(lastSalad);
                calories.remove(calories.size()-1);
                if(!calories.isEmpty()) {
                    lastSalad = calories.get(calories.size() - 1);
                }
            }else {
                calories.set(calories.size()-1,lastCalorie);
            }
            vegetables.remove(firstSalad);
        }
        System.out.println(madeSalads.toString().replaceAll("[\\[\\]]","").replaceAll(",",""));
        if(vegetables.isEmpty()){
            Collections.reverse(calories);
            System.out.println(calories.toString().replaceAll("[\\[\\]]","").replaceAll(",",""));
        }else {

            System.out.println(vegetables.toString().replaceAll("[\\[\\]]","").replaceAll(",",""));
        }
    }

}
