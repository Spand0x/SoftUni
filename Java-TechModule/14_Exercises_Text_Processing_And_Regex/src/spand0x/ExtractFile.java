package spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String fileWithExt = input[input.length-1];
        String file = fileWithExt.substring(0,fileWithExt.lastIndexOf("."));
        String extension = fileWithExt.substring(fileWithExt.lastIndexOf(".")+1);
        System.out.println("File name: " + file);
        System.out.println("File extension: " + extension);

    }
}
