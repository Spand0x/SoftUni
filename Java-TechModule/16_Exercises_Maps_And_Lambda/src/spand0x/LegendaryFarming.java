package spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mainMaterials = new TreeMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        mainMaterials.put("shards", 0);
        mainMaterials.put("fragments", 0);
        mainMaterials.put("motes", 0);
        boolean isBuilded = false;
        while (!isBuilded) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length - 1; i+=2) {
                int quantity = 0;
                String material = "";
                if (i % 2 == 0) {
                    quantity = Integer.parseInt(input[i]);
                    material = input[i + 1].toLowerCase();
                }
                if (material.equalsIgnoreCase("shards") || material.equalsIgnoreCase("fragments") || material.equalsIgnoreCase("motes")) {
                    mainMaterials.put(material, mainMaterials.get(material) + quantity);
                    if (mainMaterials.get(material) >= 250) {
                        isBuilded = true;
                        break;
                    }
                } else {
                    if (junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);

                    } else {
                        junkMaterials.put(material, quantity);
                    }
                }

            }
        }
        for (String material : mainMaterials.keySet()) {
            if (mainMaterials.get(material) >= 250) {
                if (material.equalsIgnoreCase("shards")) {
                    System.out.println("Shadowmourne obtained!");
                    mainMaterials.put(material, mainMaterials.get(material) - 250);
                } else if (material.equalsIgnoreCase("fragments")) {
                    System.out.println("Valanyr obtained!");
                    mainMaterials.put(material, mainMaterials.get(material) - 250);
                } else if (material.equalsIgnoreCase("motes")) {
                    System.out.println("Dragonwrath obtained!");
                    mainMaterials.put(material, mainMaterials.get(material) - 250);
                }
            }

        }
        mainMaterials.entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue())).forEach((e) -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.entrySet().forEach((e)-> System.out.println(e.getKey() + ": " + e.getValue()));

    }
}
