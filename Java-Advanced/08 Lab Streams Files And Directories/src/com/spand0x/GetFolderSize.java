package com.spand0x;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources");
        File init = new File(String.valueOf(path));
        ArrayDeque<File> files =new ArrayDeque<>(Arrays.asList(init.listFiles()));
        for (File file :
                files) {
            if(file.getName().equalsIgnoreCase("Exercises Resources")){
                System.out.println("Folder size: "+ file.length());
            }
        }
    }
}
