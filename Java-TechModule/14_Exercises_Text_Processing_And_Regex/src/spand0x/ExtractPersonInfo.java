package spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i< n; i++){
            String input = scanner.nextLine();

            Pattern patternName = Pattern.compile("(?<=@)\\w+(?=\\|)");
            Matcher matcherName = patternName.matcher(input);

            Pattern patternAge = Pattern.compile("(?<=#)\\d+(?=\\*)");
            Matcher matcherAge = patternAge.matcher(input);

            while(matcherName.find() && matcherAge.find()){
                System.out.println(matcherName.group() + " is " + matcherAge.group() + " years old.");
            }
        }
    }
}
