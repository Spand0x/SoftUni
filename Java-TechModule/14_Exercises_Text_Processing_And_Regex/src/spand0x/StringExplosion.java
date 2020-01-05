package spand0x;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        int power = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i)=='>'){
                char temp = sb.charAt(i);
                power += Integer.parseInt(String.valueOf(sb.charAt(i+1)));
                int count = power;
                for(int j = 0; j < count; j++){
                    sb.deleteCharAt(i+1);
                    power--;
                    if(i+1>=sb.length()||sb.charAt(i+1)=='>'){
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
