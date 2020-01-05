package spand0x;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s*,\\s*");
        Map<String, List<Double>> nameHealthAndDamage = new LinkedHashMap<>();



        for(int i = 0; i < input.length; i++){
            double totalHealth = 0;
            double totalAttack = 0.0;

            Pattern patternHealth = Pattern.compile("[^0-9+\\-\\*\\/\\.]");
            Matcher matcherHealth = patternHealth.matcher(input[i]);
            while(matcherHealth.find()){
                totalHealth += matcherHealth.group().charAt(0);
            }

            Pattern patternAttack = Pattern.compile("-?\\d*\\.?\\d+");
            Matcher matcherAttack = patternAttack.matcher(input[i]);
            while (matcherAttack.find()){
                totalAttack+=Double.parseDouble(matcherAttack.group());
            }

            for(int k = 0; k < input[i].length(); k++){
                if(input[i].charAt(k) == '*'){
                    totalAttack*=2;
                }else if(input[i].charAt(k) == '/'){
                    totalAttack/=2;
                }
            }

            nameHealthAndDamage.put(input[i],new LinkedList<>());
            nameHealthAndDamage.get(input[i]).add(totalHealth);
            nameHealthAndDamage.get(input[i]).add(totalAttack);


        }

        nameHealthAndDamage.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e->{
            System.out.printf("%s - %.0f health, %.2f damage\n", e.getKey(), e.getValue().get(0), e.getValue().get(1));
        });

    }
}
