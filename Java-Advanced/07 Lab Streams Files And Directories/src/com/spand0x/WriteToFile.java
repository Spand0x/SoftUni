package com.spand0x;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        InputStream in = new FileInputStream(inputPath);
        OutputStream out = new FileOutputStream(outputPath);
        ArrayList<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation,',','.','?','!');
        int oneByte = in.read();
        while (oneByte>=0){
            if(!punctuation.contains((char)oneByte)){
                out.write(oneByte);
            }
            oneByte = in.read();
        }
        in.close();
        out.close();
    }
}
