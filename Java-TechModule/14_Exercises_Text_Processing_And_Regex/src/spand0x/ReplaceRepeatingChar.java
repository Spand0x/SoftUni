package spand0x;

import java.util.Scanner;

public class ReplaceRepeatingChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        for(int i = 1; i < sb.length(); i++){
            if(sb.charAt(sb.length()-i)==sb.charAt(sb.length()-i-1)){
                sb.deleteCharAt(sb.length()-i);
                i--;
            }
        }
        System.out.println(sb.toString());

    }
}
