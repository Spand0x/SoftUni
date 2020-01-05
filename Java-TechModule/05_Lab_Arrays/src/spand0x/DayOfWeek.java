package spand0x;

import java.util.Scanner;

public class DayOfWeek {

    public static void main(String[] args) {
        String[] days = {"Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday"};
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n>=1 && n<=7) {
            System.out.println(days[n - 1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}
