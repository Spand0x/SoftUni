package com.spand0x;

import java.util.*;

public class Dictionary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" \\| ");
        Map<String, List<String>> wordsAndDef = new LinkedHashMap<>();

        for(String couple : input){
            String[] splited = couple.split(": ");
            String word = splited[0];
            String definition = splited[1];
            if(!wordsAndDef.containsKey(word)){
                wordsAndDef.put(word,new ArrayList<>());
            }
            wordsAndDef.get(word).add(definition);
        }

        input = scanner.nextLine().split(" \\| ");
        for(String word : input){
            if(wordsAndDef.containsKey(word)){
                System.out.println(word);
                wordsAndDef.entrySet().stream().filter(e->e.getKey().equalsIgnoreCase(word)).forEach(e->{
                    e.getValue().stream().sorted((d1,d2)->d2.length()-d1.length()).forEach(d-> System.out.println(" -"+d));
                });
            }
        }

        String finalInput = scanner.nextLine();
        if("list".equalsIgnoreCase(finalInput)){
            wordsAndDef.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e-> System.out.print(e.getKey() + " "));
        }

    }
}
