import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    @Author(name = "Spand0x")
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //Task 1: Reflection

        Class reflection = Reflection.class;
        System.out.println("class " + reflection.getName());
        System.out.println("class " + reflection.getSuperclass().getName());
        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("interface " + anInterface.getName());
        }
        Object o = reflection.getDeclaredConstructor().newInstance();
        System.out.println(o);

        //Task 2: Getters and Setters

        Method[] allMethods = reflection.getDeclaredMethods();
        Method[] getters = Arrays.stream(allMethods).filter(e-> e.getName().startsWith("get") && e.getParameterCount() == 0 && e.getReturnType() != void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Method[] setters = Arrays.stream(allMethods).filter(e->e.getName().startsWith("set") && e.getParameterCount() == 1 && e.getReturnType() == void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(e-> System.out.printf("%s will return class %s%n",e.getName(),e.getReturnType().getName()));
        Arrays.stream(setters).forEach(e-> System.out.printf("%s and will set field of class %s%n",e.getName(),e.getParameterTypes()[0].getName()));

        //Task 3: High Quality Mistakes

        Field[] allFields = reflection.getDeclaredFields();
        Arrays.stream(allFields).filter(f-> !Modifier.isPrivate(f.getModifiers()))
            .sorted(Comparator.comparing(Field::getName))
            .forEach(f-> System.out.printf("%s must be private!%n",f.getName()));
        Arrays.stream(getters).filter(g->!Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(g-> System.out.printf("%s have to be public!%n",g.getName()));
        Arrays.stream(setters).filter(s-> !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(s-> System.out.printf("%s have to be private!%n",s.getName()));

        System.out.println();
        Tracker.printMethodsByAuthor(Main.class);
        Tracker.printMethodsByAuthor(Tracker.class);
    }

}
