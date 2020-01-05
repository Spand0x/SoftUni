package com.spand0x;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        int count = 0;
        try(BufferedReader reader = Files.newBufferedReader(inputPath)){
            String line = reader.readLine();
            while (line != null){
                for (char symol:
                        line.toCharArray()) {
                    count+=symol;
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count);

    }
}
