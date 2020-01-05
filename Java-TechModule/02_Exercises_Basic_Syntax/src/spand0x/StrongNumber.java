import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sum = 0;
        int factorial = 1;
        int digit = 0;
        for (int i = 0; i < input.length(); i++) {
            digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            for (int j = 1; j <= digit; j++) {
                factorial = factorial * j;
            }
            sum += factorial;
            factorial = 1;
        }
        if (sum == Integer.parseInt(input)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
