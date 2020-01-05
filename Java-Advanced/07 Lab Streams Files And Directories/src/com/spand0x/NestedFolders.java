package com.spand0x;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File init = new File(String.valueOf(path));
        ArrayDeque<File> files = new ArrayDeque<>(Arrays.asList(init.listFiles()));
        System.out.println(init.getName());
        int count = 1;
        while (files.size() > 0){
            File current = files.poll();
            if(current.isDirectory()){
                System.out.println(current.getName());
                List<File> filesList = Arrays.asList(current.listFiles());
                files.addAll(filesList);
                count++;
            }
        }
        System.out.println(count + " folders");




        System.out.println();

    }
}
