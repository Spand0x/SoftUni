package com.spand0x;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream file = new FileInputStream(path);
        int oneByte = file.read();
        while (oneByte>=0){
            System.out.printf("%s ",Integer.toBinaryString(oneByte));
            oneByte = file.read();
        }
        file.close();
    }
}
