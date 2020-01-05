package com.spand0x;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Path wordsPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path textPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        Path outputPath = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");

        Map<String, Integer> wordsAndCount = new TreeMap<>();
        List<String> wordsList = new LinkedList<>();

        try (BufferedReader wordsInput = Files.newBufferedReader(wordsPath);
             BufferedReader textInput = Files.newBufferedReader(textPath);
             PrintWriter output = new PrintWriter(String.valueOf(outputPath))) {

            String line = wordsInput.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                wordsList.addAll(Arrays.asList(words));
                line = wordsInput.readLine();
            }
            for (String word : wordsList) {
                wordsAndCount.put(word, 0);
            }
            line = textInput.readLine();
            while (line != null) {
                String[] words = line.replaceAll("^[.,\\s]+", "").split("[.,\\s]+");
                for (String word : words) {
                    if (wordsList.contains(word)) {
                        wordsAndCount.put(word, wordsAndCount.get(word) + 1);
                    }
                }
                line = textInput.readLine();
            }
            wordsAndCount.entrySet().stream()
                    .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                    .forEach(e-> output.write(e.getKey() + " - " + e.getValue() + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
