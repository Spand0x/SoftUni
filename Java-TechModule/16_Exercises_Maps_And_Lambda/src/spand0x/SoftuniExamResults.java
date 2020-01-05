package spand0x;

import java.util.*;

public class SoftuniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();
        //List<String> banned = new LinkedList<>();
        String input = scanner.nextLine();

        while (!"exam finished".equalsIgnoreCase(input)) {
            String[] splited = input.split("-");
            if (splited[1].equalsIgnoreCase("banned")) {
                results.remove(splited[0]);
            } else {

                String name = splited[0];
                String language = splited[1];
                int points = Integer.parseInt(splited[2]);
                if(!results.containsKey(name)) {
                    results.put(name, points);
                }else if(results.get(name) < points){
                    results.put(name,points);
                }
                if (!submissions.containsKey(language)) {
                    submissions.put(language, 0);
                }
                submissions.put(language, submissions.get(language) + 1);


            }
            input = scanner.nextLine();
        }
        if (!results.isEmpty()) {
            System.out.println("Results:");
        }
        results.entrySet().stream().sorted((s1, s2) -> {
            int temp = s2.getValue().compareTo(s1.getValue());
            //System.out.println("result test: " + s1.getKey() + s1.getValue() + " " + s2.getKey() +s2.getValue() + " : " + temp);
            if (temp == 0) {
                temp = s1.getKey().compareTo(s2.getKey());

            }
            return temp;
        }).forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
        if (!submissions.isEmpty()) {
            System.out.println("Submissions:");
        }
        submissions.entrySet().stream().sorted((s1, s2) -> {
            int temp = s2.getValue().compareTo(s1.getValue());
            if (temp == 0) {
                temp = s1.getKey().compareTo(s2.getKey());
            }
            return temp;
        }).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}
