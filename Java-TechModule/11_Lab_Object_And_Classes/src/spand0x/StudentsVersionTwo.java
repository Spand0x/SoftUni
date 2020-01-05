package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsVersionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Student> students = new ArrayList<>();
        while(!"end".equals(input[0])){
            if(isStudentExist(students,input[0],input[1])){
                Student student = getStudent(students,input[0],input[1]);

                student.setAge(Integer.parseInt(input[2]));
                student.setHomeTown(input[3]);

            }else{

                Student student = new Student();
                student.setFirstName(input[0]);
                student.setLastName(input[1]);
                student.setAge(Integer.parseInt(input[2]));
                student.setHomeTown(input[3]);
                students.add(student);
            }

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

    private static boolean isStudentExist(List<Student> students, String firstName, String lastName){
        if(students.isEmpty()){
            return false;
        }
        for(Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName){

        for(Student student: students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }
}

