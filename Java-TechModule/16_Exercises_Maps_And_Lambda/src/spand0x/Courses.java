package spand0x;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(" : ");

        while(!"end".equalsIgnoreCase(input[0])){
            String course = input[0];
            String name = input[1];
            if(!courses.containsKey(course)){
                courses.put(course,new ArrayList<>());
            }
            courses.get(course).add(name);


            input = scanner.nextLine().split(" : ");
        }
        courses.entrySet().stream().sorted((e1,e2) -> {
            int sumFirst = e1.getValue().size();
            int sumSecond = e2.getValue().size();
            return sumSecond - sumFirst;
        }).forEach((e1) -> {
            System.out.println(e1.getKey() + ": " + e1.getValue().size());
            e1.getValue().stream().sorted(String::compareTo).forEach(element -> System.out.println("-- " + element));
        });

    }
}
