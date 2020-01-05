package spand0x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        List<String> result = new ArrayList<>();
        for(int i = input.length-1; i>=0;i--){
            result.add(input[i]);
        }
        String last = result.toString().replaceAll("[\\[\\]\\,/ +/g]", " ");
        System.out.println(last.replaceAll("\\s{2,}", " ").trim());
    }
}
