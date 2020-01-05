package com.spand0x;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyAPicture {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\Skyline.jpg");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\CopyOfSkyline.jpg");

        try( FileInputStream input = new FileInputStream(String.valueOf(inputPath));
             FileOutputStream output = new FileOutputStream(String.valueOf(outputPath))){
            byte[] picture = input.readAllBytes();
            output.write(picture);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
