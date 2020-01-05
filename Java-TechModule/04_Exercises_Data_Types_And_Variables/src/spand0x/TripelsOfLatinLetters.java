package spand0x;

import java.util.Scanner;

public class TripelsOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i <n; i++){
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print((char)((i+'a')));
                    System.out.print((char)((j+'a')));
                    System.out.println((char)((k+'a')));
                }
            }
        }
    }
}
