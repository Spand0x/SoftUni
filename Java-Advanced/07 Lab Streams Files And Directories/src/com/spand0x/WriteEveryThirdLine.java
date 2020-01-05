package com.spand0x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader in = new BufferedReader(new FileReader(inputPath));
        FileWriter out = new FileWriter(outputPath);
        String line = in.readLine();
        int count = 1;
        while (line != null){
            if(count % 3 == 0){
                out.write(line + "\n");
            }
            count++;
            line = in.readLine();
        }



        in.close();
        out.close();

    }
}
