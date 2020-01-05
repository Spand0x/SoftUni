package com.spand0x;

import java.util.*;

public class Concert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> bandAndTime = new LinkedHashMap<>();
        Map<String, LinkedHashSet<String>> bandAndMembers = new LinkedHashMap<>();
        int totalTime = 0;

        String input = scanner.nextLine();
        while(!"start of concert".equalsIgnoreCase(input)){
            String[] command = input.trim().split("; ");
            if(command[0].equalsIgnoreCase("add")){
                if(!bandAndMembers.containsKey(command[1])){
                    bandAndMembers.put(command[1],new LinkedHashSet<>());
                    bandAndTime.put(command[1],0);
                }
                String[] members = command[2].trim().split(", ");
                for(String member : members){
                    bandAndMembers.get(command[1]).add(member);
                }
            }else if(command[0].equalsIgnoreCase("play")){
                totalTime+=Integer.parseInt(command[2]);
                if(!bandAndTime.containsKey(command[1])){
                    bandAndTime.put(command[1],Integer.parseInt(command[2]));
                    bandAndMembers.put(command[1],new LinkedHashSet<>());
                }else{
                    bandAndTime.put(command[1],(bandAndTime.get(command[1]))+Integer.parseInt(command[2]));
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Total time: " + totalTime);
        bandAndTime.entrySet().stream().sorted((b1,b2)->{
            int result = b2.getValue().compareTo(b1.getValue());
            if(result == 0){
                return b1.getKey().compareTo(b2.getKey());
            }
            return result;

        }).forEach(e->{
            System.out.println(e.getKey() + " -> " + e.getValue());
        });

        String band = scanner.nextLine();
        System.out.println(band);
        bandAndMembers.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase(band)).forEach(e->e.getValue().stream().forEach(member-> System.out.println("=> " + member)));

    }
}
