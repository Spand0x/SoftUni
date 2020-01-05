package spand0x;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> students = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if(students.containsKey(name)){
                double previousGrade = students.get(name);
                double average = (previousGrade+grade)/2;
                students.put(name,average);
            }else{
                students.put(name,grade);
            }
        }
        students.entrySet().stream().filter(e->e.getValue()>=4.5)
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .forEach(e-> System.out.printf("%s -> %.2f\n",e.getKey(),e.getValue()));



    }
}
