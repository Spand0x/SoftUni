package validperson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Person person = new Person("Valid", "validator", 20);
            Person person1 = new Person("", "Testov", 10);
            Person person2 = new Person("Pesho", null, 13);
            Person person3 = new Person("Gosho","Goshev",-1);
            Person person4 = new Person("Gosho","tretov",123);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            Student student = new Student("4avdar4o","mail@mail.bg");
        }catch (InvalidPersonNameException e){
            System.out.println(e.getMessage());
        }
    }
}
