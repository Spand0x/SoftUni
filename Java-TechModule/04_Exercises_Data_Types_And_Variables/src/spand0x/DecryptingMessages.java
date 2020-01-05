package spand0x;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < n; i++){
            char extract = scanner.nextLine().charAt(0);
            message.append((char) (extract + key));
        }
        System.out.println(message);
    }
}
