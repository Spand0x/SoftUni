package blackboxinteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String[] input = scanner.nextLine().split("_");
        while (!"END".equals(input[0])){
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            Method[] methods = blackBoxInt.getClass().getDeclaredMethods();

            for (Method method : methods) {
                if(command.equals(method.getName())){
                    method.setAccessible(true);
                    method.invoke(blackBoxInt,number);
                    break;
                }
            }

            System.out.println(innerValue.getInt(blackBoxInt));

            input = scanner.nextLine().split("_");
        }
    }
}
