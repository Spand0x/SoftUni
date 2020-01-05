package spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Integer> miner = new LinkedHashMap<>();
        while(!"stop".equalsIgnoreCase(input)){
            int amount = Integer.parseInt(scanner.nextLine());
            if(miner.containsKey(input)){
                miner.put(input,miner.get(input) + amount);
            }else{
                miner.put(input,amount);
            }

            input = scanner.nextLine();
        }
        for(Map.Entry resource : miner.entrySet()){
            System.out.println(resource.getKey() + " -> " + resource.getValue());
        }
    }
}
