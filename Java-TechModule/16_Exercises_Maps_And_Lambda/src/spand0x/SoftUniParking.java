package spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingList = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            String[] input = scanner.nextLine().split(" ");
            if(input[0].equalsIgnoreCase("register")){
                if(parkingList.containsKey(input[1])){
                    System.out.println("ERROR: already registered with plate number " + parkingList.get(input[1]));
                }else{
                    parkingList.put(input[1],input[2]);
                    System.out.println(input[1] + " registered " + input[2] + " successfully");
                }
            }else{
                if(parkingList.containsKey(input[1])){
                    System.out.println(input[1] + " unregistered successfully");
                    parkingList.remove(input[1]);
                }else{
                    System.out.println("ERROR: user " + input[1] + " not found");
                }
            }

        }
        parkingList.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
