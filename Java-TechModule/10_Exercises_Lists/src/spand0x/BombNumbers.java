package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int number = input[0];
        int power = input[1];
        while(intList.contains(number)){
            int indexOfNumber = intList.indexOf(number);
            int startingIndex = indexOfNumber-power;
            int endingIndex = indexOfNumber+power;
            int numbersToRemove = endingIndex-startingIndex+1;
            if(numbersToRemove >= intList.size()-startingIndex){
                numbersToRemove = intList.size()-startingIndex;
            }
            if(startingIndex<0){
                numbersToRemove = numbersToRemove+startingIndex;
                startingIndex = 0;
            }
            for(int i = 0; i < numbersToRemove; i++){
                intList.remove(startingIndex);
            }
        }
        int sum = 0;
        for (int element: intList) {
            sum+=element;
        }
        System.out.println(sum);
    }
}
