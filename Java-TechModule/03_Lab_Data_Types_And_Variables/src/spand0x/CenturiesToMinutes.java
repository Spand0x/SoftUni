package spand0x;

import java.math.BigDecimal;
import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int years = input*100;
        int days = (int)(years*365.2422);
        int hours = days*24;
        BigDecimal minutes = new BigDecimal(hours*60);
        System.out.println(input + " centuries = " + years + " years = " + days + " days = " + hours + " hours = " + minutes + " minutes");
    }
}
