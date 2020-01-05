package spand0x;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> planets = new LinkedHashMap<>();
        planets.put("Attacked",new LinkedList<>());
        planets.put("Destroyed", new LinkedList<>());
        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            int countLetters = 0;

            for(int j = 0; j < input.length(); j++){
                if(input.charAt(j) == 's' || input.charAt(j) == 'S' || input.charAt(j) == 't' || input.charAt(j) == 'T' ||
                        input.charAt(j) == 'R' || input.charAt(j) == 'r' || input.charAt(j) == 'A' || input.charAt(j) == 'a'){
                    countLetters++;
                }
            }

            StringBuilder decrypted = new StringBuilder();
            for(int k = 0; k< input.length(); k++){
                decrypted.append((char)(input.charAt(k)-countLetters));
            }

            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)([^@\\,\\-!\\:>]*):(?<population>\\d+)([^@\\,\\-!\\:>]*)\\!(?<type>[AD])!([^@\\,\\-!\\:>]*)->;(?<count>\\d+)");
            Matcher matcher = pattern.matcher(decrypted.toString());
            while(matcher.find()){
                if(matcher.group("type").equals("A")){
                    planets.get("Attacked").add(matcher.group("name"));
                }else if(matcher.group("type").equals("D")){
                    planets.get("Destroyed").add(matcher.group("name"));
                }
            }
        }
        planets.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e->{
            System.out.println(e.getKey()+" planets: " + e.getValue().size());
            e.getValue().stream().sorted(String::compareTo).forEach(p->{
                System.out.println("-> " + p);
            });
        });

    }
}
