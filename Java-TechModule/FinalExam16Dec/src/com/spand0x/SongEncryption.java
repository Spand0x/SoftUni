package com.spand0x;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(!"end".equalsIgnoreCase(input)){
            Pattern pattern = Pattern.compile("^[A-Z][a-z\\s']+:[A-Z\\s]+$");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                System.out.print("Successful encryption: ");
                String[] artistAndSong = input.split(":");
                int length = artistAndSong[0].length();
                for(int i = 0; i < input.length(); i++){
                    char currentChar = input.charAt(i);
                    boolean small = false;
                    if(currentChar>=97 && currentChar<=122){
                        small = true;
                    }
                    char decrypted = (char) (currentChar+length);
                    if(currentChar == ' '){
                        decrypted = ' ';
                    }else if(currentChar == '\''){
                        decrypted = '\'';
                    }else if(currentChar == ':'){
                        decrypted = '@';
                    } else if (small && decrypted>122) {
                        decrypted = (char)((decrypted-122)+96); //maybe 96, check
                    }else if(!small && decrypted>90){
                        decrypted = (char)((decrypted-90)+64); //mayve 64, check
                    }
                    System.out.print(decrypted);
                }
                System.out.println();
            }else{
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();
        }
    }
}
