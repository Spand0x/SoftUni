package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Student> students = new ArrayList<>();
        while(!"end".equals(input[0])){
            Student student = new Student(input[0],input[1],Integer.parseInt(input[2]),input[3]);
            students.add(student);
            input = scanner.nextLine().split(" ");
        }
        String city = scanner.nextLine();
        for (Student student :
                students) {
            if(city.equals(student.getHomeTown())){
                System.out.printf("%s %s is %d years old\n",student.getFirstName(),student.getLastName(),student.getAge());
            }
        }

    }
}

