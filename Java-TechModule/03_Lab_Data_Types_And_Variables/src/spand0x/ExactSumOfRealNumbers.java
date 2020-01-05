package spand0x;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for(int i = 0; i < n; i++){
            BigDecimal add = new BigDecimal(scanner.nextLine());
            sum = sum.add(add);
        }
        System.out.println(sum);
    }
}
