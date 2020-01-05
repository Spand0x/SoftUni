package com.spand0x;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser");
        ArrayList<Double> arrList = new ArrayList<>();
        arrList.add(1.1d);
        arrList.add(2.2d);
        arrList.add(3.1d);
        arrList.add(4.1d);

        try(FileOutputStream fos = new FileOutputStream(String.valueOf(path));
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(arrList);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream inputStream = new FileInputStream(String.valueOf(path));
            ObjectInputStream objectInput = new ObjectInputStream(inputStream)){
            List<Double> deserialize = (List<Double>) objectInput.readObject();
            deserialize.forEach(System.out::println);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

