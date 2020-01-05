package com.spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> miner = new LinkedHashMap<>();
        while (!resource.equalsIgnoreCase("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if(miner.containsKey(resource)){
                miner.put(resource,miner.get(resource)+quantity);
            }else {
                miner.put(resource, quantity);
            }
            resource = scanner.nextLine();
        }
        for (String key :
                miner.keySet()) {
            System.out.println(key + " -> " + miner.get(key));
        }
    }
}
