import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReflectionDemoTest {
    @Test
    public void amountPersonObjectsTest() {
        List<Object> objects = new ArrayList<>();
        objects.add(new Human("a", 1));
        objects.add(new Human("a", 1));
        objects.add(new Human("a", 1));
        objects.add(new Student("a", 1, "b", 1));
        objects.add(new Student("a", 1, "b", 1));
        Assert.assertEquals(5, ReflectionDemo.amountPersonObjects(objects));
    }

    @Test
    public void getOpenMethodsTest() {
        Comparator<String> comparator = String::compareTo;
        Human human = new Human("a", 1);
        ArrayList<String> list = new ArrayList<>(
                List.of("getFullName", "equals", "hashCode", "setFullName", "getAge", "setAge", "toString"));
        list.sort(comparator);
        List<String> result = ReflectionDemo.getOpenMethods(human);
        result.sort(comparator);
        Assert.assertEquals(list, result);
    }

    @Test
    public void getSuperclassesNamesTest() {
        Student student = new Student("a", 1, "b", 1);
        Assert.assertEquals(List.of("Human", "java.lang.Object"), ReflectionDemo.getSuperclassesNames(student));
    }
}
