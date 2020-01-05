package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double leftRacerTime = 0;
        double rightRacerTime = 0;
        for(int i = 0, j = input.length-1; i<input.length/2;i++,j--){
            if(input[i]==0){
                leftRacerTime = leftRacerTime * 0.8;
            }else{
                leftRacerTime+=input[i];
            }
            if(input[j]==0){
                rightRacerTime = rightRacerTime * 0.8;
            }else {
                rightRacerTime += input[j];
            }
        }
        if(leftRacerTime<rightRacerTime){
            System.out.printf("The winner is left with total time: %.1f",leftRacerTime);
        }else{
            System.out.printf("The winner is right with total time: %.1f",rightRacerTime);
        }
    }
}
