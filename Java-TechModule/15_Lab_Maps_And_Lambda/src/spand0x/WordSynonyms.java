package spand0x;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<String>> synonyms = new LinkedHashMap<>();
        for(int i = 0; i < n; i++){
            String keyWord = scanner.nextLine();
            String valueWord = scanner.nextLine();
            synonyms.putIfAbsent(keyWord,new ArrayList<>());
            synonyms.get(keyWord).add(valueWord);

        }
        for(Map.Entry<String,ArrayList<String>> map : synonyms.entrySet()){
            System.out.print(map.getKey() + " - ");
            System.out.println(map.getValue().toString().replaceAll("[\\[\\]]",""));
        }
    }
}
