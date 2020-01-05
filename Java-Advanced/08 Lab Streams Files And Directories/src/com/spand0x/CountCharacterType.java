package com.spand0x;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacterType {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        try(BufferedReader input = Files.newBufferedReader(inputPath);
            PrintWriter output = new PrintWriter(new FileWriter(String.valueOf(outputPath)))){
            String line = input.readLine();
            while(line != null){
                for (char symbol: line.toCharArray()) {
                    if(symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u'){
                        countVowels++;
                    }else if(symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?' ){
                        countPunctuation++;
                    }else if(symbol != ' '){
                        countConsonants++;
                    }
                }
                line = input.readLine();
            }
            output.write("Vowels: " + countVowels);
            output.write("\nConsonants: " + countConsonants);
            output.write("\nPunctuation: " + countPunctuation);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
