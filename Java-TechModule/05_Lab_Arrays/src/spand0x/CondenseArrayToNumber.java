package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = input[0];
        while(input.length>1) {
            int[] condensed = new int[input.length-1];
            for (int i = 0; i < input.length-1; i++) {
                condensed[i] = input[i]+input[i+1];
            }
            input=condensed;
            result = condensed[0];
        }
        System.out.println(result);
    }
}
