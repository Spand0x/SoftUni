package com.spand0x;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        try(BufferedReader input = Files.newBufferedReader(inputPath);
            PrintWriter output = new PrintWriter(new FileWriter(String.valueOf(outputPath)))){
            String line = input.readLine();
            while (line != null) {
                String upperLine = line.toUpperCase();
                output.write(upperLine + "\n");
                line = input.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
