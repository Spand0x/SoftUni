package spand0x;

import java.util.Scanner;

public class RepeateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String result = appendString(input,n);
        System.out.println(result);
    }

    private static String appendString(String input,int n) {
        String result = "";
        for(int i = 0; i<n;i++){
            result+=input;
        }
        return result;
    }
}
