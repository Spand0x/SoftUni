package spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(^|(?<=\\s)(?!_))(\\w+[\\.-]?\\w+)@[A-Za-z-]+(\\.[A-Za-z]+)+");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            System.out.println(matcher.group());
        }


    }
}
