package spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distance = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> removed = new ArrayList<>();

        while (!distance.isEmpty()) {

            int index = Integer.parseInt(scanner.nextLine());
            int element = 0;
            if (index < 0) {
                element = distance.get(0);
                distance.remove(0);
                distance.add(0,distance.get(distance.size()-1));
            } else if (index >= distance.size()) {
                element = distance.get(distance.size()-1);
                distance.remove(distance.size()-1);
                distance.add(distance.get(0));
            }else{
                element = distance.get(index);
                distance.remove(index);
            }
            removed.add(element);
            for (int i = 0; i < distance.size(); i++) {
                if (distance.get(i) <= element) {
                    distance.set(i, distance.get(i) + element);
                } else {
                    distance.set(i, distance.get(i) - element);
                }
            }


        }
        int sum = 0;
        for (int element :
                removed) {
            sum+=element;
        }
        System.out.println(sum);
    }
}
