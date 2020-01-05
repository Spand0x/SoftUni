package com.spand0x;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        Path inputOne = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\InputOne.txt");
        Path inputTwo = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\InputTwo.txt");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");


        try{
            List<String> readerOne = Files.readAllLines(inputOne);
            readerOne.addAll(Files.readAllLines(inputTwo));
            Files.write(outputPath,readerOne);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
