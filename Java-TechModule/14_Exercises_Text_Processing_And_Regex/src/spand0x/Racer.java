package spand0x;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Racer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, Integer> racers = new LinkedHashMap<>();

        while (!"end of race".equalsIgnoreCase(input)){
            StringBuilder name = new StringBuilder();
            int time = 0;
            for(int i = 0; i < input.length(); i++){
                char character = input.charAt(i);
                if(Character.isLetter(character)){
                    name.append(character);
                }else if(Character.isDigit(character)){
                    time+=Integer.parseInt(String.valueOf(character));
                }
            }
            if(people.contains(String.valueOf(name))){
                if(racers.containsKey(String.valueOf(name))){
                    racers.put(String.valueOf(name), racers.get(String.valueOf(name))+time);
                }else{
                    racers.put(String.valueOf(name),time);
                }
            }
            input = scanner.nextLine();
        }
        LinkedHashMap<String,Integer> sorted = sort(racers);
        List<String> result = new LinkedList<>(sorted.keySet());
        System.out.println("1st place: " + result.get(0));
        System.out.println("2nd place: " + result.get(1));
        System.out.println("3rd place: " + result.get(2));

    }

    public static LinkedHashMap<String,Integer> sort(Map<String,Integer> map){
        return map.entrySet().stream().sorted((r1,r2)->r2.getValue().compareTo(r1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    }
}
