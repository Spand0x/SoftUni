package com.spand0x;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\Programming\\SoftUni\\08. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser");
        Course course = new Course("Softuni", 10);

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(String.valueOf(path)))){
            output.writeObject(course);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(String.valueOf(path)))) {
            Course deserializeObject = (Course) input.readObject();
            System.out.println(deserializeObject.getName());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
class Course implements Serializable{
    String name;
    Integer students;

    public Course(String name, Integer students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Integer getStudents() {
        return students;
    }
}
