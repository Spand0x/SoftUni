package harvestingfields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"HARVEST".equals(input)) {
            printFields(input);
            input = scanner.nextLine();
        }
    }

    private static void printFields(String modifier) {
        Field[] fields = RichSoilLand.class.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            if(modifier.equals("all")){
                sb.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()) .append(" ").append(field.getName()).append(System.lineSeparator());
            }
            if (Modifier.toString(field.getModifiers()).equals(modifier)) {
                sb.append(modifier).append(" ").append(field.getType().getSimpleName()) .append(" ").append(field.getName()).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
