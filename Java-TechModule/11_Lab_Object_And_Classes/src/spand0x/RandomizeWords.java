package spand0x;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Random rnd = new Random();
        for(int i = 0; i < input.length ; i++){
            int pos = rnd.nextInt(input.length);
            String temp = input[i];
            input[i] = input[pos];
            input[pos] = temp;
        }
        System.out.println(String.join(System.lineSeparator(),input));
    }
}
