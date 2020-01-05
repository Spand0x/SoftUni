package spand0x;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        topNumber(n);
    }

    private static void topNumber(int n) {
        for (int i = 1; i <= n; i++) {
            String stringN = i + "";
            int sum = 0;
            boolean hasOdd = false;
            for (int j = 0; j < stringN.length(); j++) {
                sum += Integer.parseInt(String.valueOf(stringN.charAt(j)));
            }
            for(int j = 0; j < stringN.length();j++){
                int number = Integer.parseInt(String.valueOf(stringN.charAt(j)));
                if(number % 2 != 0){
                    hasOdd = true;
                    break;
                }
            }
            if (sum % 8 == 0 && hasOdd) {
                System.out.println(i);
            }
        }
    }
}
