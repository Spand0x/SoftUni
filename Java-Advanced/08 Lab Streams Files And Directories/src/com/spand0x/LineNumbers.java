package com.spand0x;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        try(BufferedReader input = Files.newBufferedReader(inputPath);
            FileWriter output = new FileWriter(String.valueOf(outputPath))){
            String line = input.readLine();
            int count = 1;
            while (line != null){
                output.write(count + ". " + line + "\n");
                count++;
                line = input.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
