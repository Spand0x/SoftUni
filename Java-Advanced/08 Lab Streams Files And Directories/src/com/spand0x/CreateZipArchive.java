package com.spand0x;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        Path zipPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip");
        String fileOne = "D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String fileTwo = "D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String fileThree = "D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try(FileInputStream inputOne = new FileInputStream(fileOne);
            FileInputStream inputTwo = new FileInputStream(fileTwo);
            FileInputStream inputThree = new FileInputStream(fileThree);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(String.valueOf(zipPath)))){

            ZipEntry entry = new ZipEntry("inputOne.txt");
            zipOut.putNextEntry(entry);
            byte[] container = inputOne.readAllBytes();
            zipOut.write(container);

            zipOut.closeEntry();
            zipOut.putNextEntry(new ZipEntry("inputTwo.txt"));
            container = inputTwo.readAllBytes();
            zipOut.write(container);

            zipOut.closeEntry();
            zipOut.putNextEntry(new ZipEntry("inputLineNumbers.txt"));
            container = inputThree.readAllBytes();
            zipOut.write(container);

            zipOut.closeEntry();
            zipOut.finish();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
