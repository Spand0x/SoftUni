package spand0x;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banned = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for(String ban: banned){
            while (text.contains(ban)){
                String replacement = repeatStr("*",ban.length());
                text = text.replace(ban,replacement);
            }
        }
        System.out.println(text);
    }
    public static String repeatStr(String str, int length){
        String replacement = "";
        for(int i = 0; i < length; i++){
            replacement+=str;
        }

        return replacement;
    }
}
