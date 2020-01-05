package com.spand0x;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File files = new File(String.valueOf(path));
        if(files.exists()){
            File[] file = files.listFiles();
            for (File f :
                    file) {
                if(!f.isDirectory()){
                    System.out.printf("%s: [%d]%n",f.getName(),f.length());
                }
            }
        }
    }
}
