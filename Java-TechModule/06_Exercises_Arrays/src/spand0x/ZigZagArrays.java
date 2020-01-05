package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0) {
                firstArray[i] = temp[0];
                secondArray[i] = temp[1];
            } else {
                firstArray[i] = temp[1];
                secondArray[i] = temp[0];

            }
        }
        for (int element :
                firstArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element :
                secondArray) {
            System.out.print(element + " ");
        }
    }
}
