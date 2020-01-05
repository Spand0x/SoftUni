package spand0x;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> book = new LinkedHashMap<>();
        HashSet<String> allUsers = new HashSet<>();

        String input = scanner.nextLine();

        while (!"Lumpawaroo".equalsIgnoreCase(input)) {
            if (input.contains(" | ")) {
                String[] temp = input.split(" \\| ");
                String side = temp[0];
                String user = temp[1];

                if (!book.containsKey(side)) {
                    book.put(side, new HashSet<>());
                }

                if(book.entrySet().stream().noneMatch(e-> e.getValue().contains(user))){
                    book.get(side).add(user);
                }

            } else if (input.contains(" -> ")) {

                String[] temp = input.split(" -> ");
                String side = temp[1];
                String user = temp[0];
                book.forEach((key, value) -> value.remove(user));

                if (!book.containsKey(side)) {
                    book.put(side, new HashSet<>());
                }
                book.get(side).add(user);
                System.out.printf("%s joins the %s side!\n", user, side);
            }
            input = scanner.nextLine();
        }


        book.entrySet().stream().filter(e->e.getValue().size()>0).sorted((e1, e2) -> {
            int res = e2.getValue().size() - e1.getValue().size();
            if (res == 0) {
                res = e1.getKey().compareTo(e2.getKey());
            }
            return res;
        }).forEach(e1 -> {
            System.out.println("Side: " + e1.getKey() + ", Members: " + e1.getValue().size());
            e1.getValue().stream().sorted(Comparator.naturalOrder()).forEach(u -> System.out.println("! " + u));

        });


    }
}
