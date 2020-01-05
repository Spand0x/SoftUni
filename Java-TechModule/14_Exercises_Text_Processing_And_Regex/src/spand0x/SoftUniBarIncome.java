package spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile
                ("^%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?)\\$");
        double totalIncome = 0.0;

        while(!"end of shift".equalsIgnoreCase(input)){
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){
                double totalPrice = Double.parseDouble(matcher.group("count")) * Double.parseDouble(matcher.group("price"));
                totalIncome += totalPrice;
                System.out.printf("%s: %s - %.2f\n",matcher.group("name"), matcher.group("product"), totalPrice);
            }

            input = scanner.nextLine();

        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
