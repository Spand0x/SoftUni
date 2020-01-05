package spand0x;

import java.lang.reflect.Array;
import java.util.*;

public class OddOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();
        for(String word: words){
            String wordSmallLetters = word.toLowerCase();
            if(counts.containsKey(wordSmallLetters)){
                counts.put(wordSmallLetters,counts.get(wordSmallLetters)+1);
            }else{
                counts.put(wordSmallLetters,1);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String key : counts.keySet()){
            if(counts.get(key)%2 == 1){
                result.add(key);
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]",""));
    }
}
