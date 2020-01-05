package enternumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                if (start < 1 || start > 100) {
                    throw new IllegalArgumentException("Start must be between 1 and 100");
                }
                int end = Integer.parseInt(scanner.nextLine());
                if (end < 1 || end > 100) {
                    throw new IllegalArgumentException("End must be between 1 and 100");
                }
                printNumbers(start,end);
                return;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a valid number");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void  printNumbers(int start, int end){
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
