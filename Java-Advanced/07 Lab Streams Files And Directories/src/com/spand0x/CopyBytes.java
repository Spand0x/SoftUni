package com.spand0x;


import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\Programming\\SoftUni\\07. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        InputStream in = new FileInputStream(inputPath);
        OutputStream out = new FileOutputStream(outputPath);
        int oneByte = in.read();
        while (oneByte>=0){
            String symbol = String.valueOf(oneByte);
            if(symbol.equalsIgnoreCase("10") || symbol.equalsIgnoreCase("32")) {
                out.write(oneByte);
            }else {
                for (int i = 0; i < symbol.length(); i++) {
                    out.write(symbol.charAt(i));
                }
            }
            oneByte = in.read();
        }


        in.close();
        out.close();
    }
}
