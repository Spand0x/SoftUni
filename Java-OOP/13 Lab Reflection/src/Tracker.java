import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Tracker {

    @Author(name = "Gosho")
    public static void printMethodsByAuthor(Class<?> cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if(annotation != null) {
                System.out.println(annotation.name() + " " + method.getName());
            }
        }
    }
}
