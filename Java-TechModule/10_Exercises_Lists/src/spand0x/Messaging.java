package spand0x;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        for(int i = 0; i < numbers.size(); i++){
            int sum = 0;
            String number = numbers.get(i);
            for(int j = 0; j < number.length();j++){
                sum += Integer.parseInt(String.valueOf(number.charAt(j)));
                if(sum>=input.length()){
                    sum = sum-input.length();
                }
            }
            System.out.print(input.charAt(sum));
            String temp = "";
            temp = input.substring(0,sum);
            temp += input.substring(sum+1);
            input = temp;


        }
    }
}
