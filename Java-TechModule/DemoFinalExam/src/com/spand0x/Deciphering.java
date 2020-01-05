package com.spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String crypted = scanner.nextLine();
        String[] substrings = scanner.nextLine().split(" ");

        Pattern pattern = Pattern.compile("^([d-z{}|#]+)$");
        Matcher matcher = pattern.matcher(crypted);
        if (matcher.find()) {

            StringBuilder decrypting = new StringBuilder();
            for (int i = 0; i < crypted.length(); i++) {
                char temp = (char) (crypted.charAt(i) - 3);
                decrypting.append(temp);
            }
//        System.out.println(decrypting.toString());
            String decrypted = decrypting.toString();
            decrypted = decrypted.replaceAll(substrings[0], substrings[1]);
            System.out.println(decrypted);
        }else{
            System.out.println("This is not the book you are looking for.");
        }
    }
}
