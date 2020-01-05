package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPersonCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPersonCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while(!firstPersonCards.isEmpty() && !secondPersonCards.isEmpty()){
            int firstCardFirstPerson = firstPersonCards.get(0);
            int firstCardSecondPerson = secondPersonCards.get(0);
            firstPersonCards.remove(0);
            secondPersonCards.remove(0);
            if(firstCardFirstPerson==firstCardSecondPerson){

            }else if(firstCardFirstPerson>firstCardSecondPerson){
                firstPersonCards.add(firstCardFirstPerson);
                firstPersonCards.add(firstCardSecondPerson);
            }else{
                secondPersonCards.add(firstCardSecondPerson);
                secondPersonCards.add(firstCardFirstPerson);
            }
        }
        boolean firstWins = false;
        int sum = 0;
        if(!firstPersonCards.isEmpty()){
            firstWins = true;
            for (int cards :
                    firstPersonCards) {
                sum += cards;
            }
        }else{
            for(int cards : secondPersonCards){
                sum+= cards;
            }
        }
        if(firstWins){
            System.out.println("First player wins! Sum: " + sum);
        }else{
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
