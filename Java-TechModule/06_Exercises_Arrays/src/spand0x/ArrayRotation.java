package spand0x;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int first = intArr[0];
            for (int j = 0; j < intArr.length - 1; j++) {
                intArr[j] = intArr[j + 1];
            }
            intArr[intArr.length - 1] = first;
        }
        for (int element :
                intArr) {
            System.out.print(element + " ");
        }
    }
}
