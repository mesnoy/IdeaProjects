import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionDemo {
    public static int amountPersonObjects(List<Object> list) {
        int result = 0;
        for (Object obj : list) {
            if (obj instanceof Human) {
                result++;
            }
        }
        return result;
    }

    public static List<String> getOpenMethods(Object obj) {
        Method[] methods = (obj.getClass().getDeclaredMethods());
        List<String> result = new ArrayList<>();
        for (Method method : methods) {
            if ((method.getModifiers() & 1) == 1) {
                result.add(method.getName());
            }
        }
        return result;
    }

    /*public static List<String> getSuperclassesNames(Object obj) {
        String classes = obj.getClass().getCanonicalName().split("\\.");
        return Arrays.asList(classes);
    }*/

    public static List<String> getSuperclassesNames(Object object) {
        List<String> superclasses = new ArrayList<>();
        Class<?> superclass = object.getClass();
        while (superclass != Object.class) {
            superclass = superclass.getSuperclass();
            superclasses.add(superclass.getName());
        }
        return superclasses;
    }
}
