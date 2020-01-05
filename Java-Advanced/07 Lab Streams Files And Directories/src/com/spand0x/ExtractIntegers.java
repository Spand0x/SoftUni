package com.spand0x;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner in = new Scanner(new FileInputStream(inputPath));
        PrintWriter out = new PrintWriter(outputPath);

        while (in.hasNext()){
            if(in.hasNextInt()){
                out.println(in.nextInt());
            }
            in.next();
        }


        in.close();
        out.close();


    }
}
