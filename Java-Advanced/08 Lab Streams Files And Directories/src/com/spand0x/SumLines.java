package com.spand0x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {

        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try(BufferedReader reader = Files.newBufferedReader(inputPath)){
            String line = reader.readLine();
            while (line != null){
                int count = 0;
                for (char symol:
                        line.toCharArray()) {
                    count+=symol;
                }
                System.out.println(count);
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
