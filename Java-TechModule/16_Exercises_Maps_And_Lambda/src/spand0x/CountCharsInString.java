package spand0x;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        Map<Character, Integer> count = new LinkedHashMap<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                continue;
            }
            if(count.containsKey(input.charAt(i))){
                count.put(input.charAt(i),count.get(input.charAt(i))+1);
            }else{
                count.put(input.charAt(i),1);
            }
        }
        for(Map.Entry character : count.entrySet()){
            System.out.println(character.getKey() + " -> " + character.getValue());
        }
    }
}
