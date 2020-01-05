package spand0x;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedList<String> furniture = new LinkedList<String>();
        double totalPrice = 0.0;

        while(!"Purchase".equalsIgnoreCase(input)){
            int count = 0;
            double price = 0.0;

            Pattern pattern = Pattern.compile("(?<=>)(?<furniture>\\w+)(?=<)<+(?<price>[\\d\\.?\\d?]+)\\!(?<count>\\d+)");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                furniture.add(matcher.group("furniture"));
                price = Double.parseDouble(matcher.group("price"));
                count = Integer.parseInt(matcher.group("count"));
            }
            totalPrice+=price*count;



            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String item :
                furniture) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f",totalPrice);

    }
}
