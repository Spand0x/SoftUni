package spand0x;

import java.util.*;
import java.util.stream.Collector;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<PersonVersionTwo> personList = new ArrayList<>();
        while (!"End".equals(input[0])){
            PersonVersionTwo person = new PersonVersionTwo(input[0],input[1],Integer.parseInt(input[2]));
            personList.add(person);
            input = scanner.nextLine().split(" ");
        }

        personList.stream().sorted(Comparator.comparing(PersonVersionTwo::getAge)).forEach(element ->
                System.out.printf("%s with ID: %s is %d years old.\n",element.getName(),element.getId(),element.getAge()));

    }
}

class PersonVersionTwo{
    private String name;
    private String id;
    private int age;

    public PersonVersionTwo(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
