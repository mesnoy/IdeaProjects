import java.util.Objects;
import java.util.function.*;

public class LambdaDemo {
    public static Function<String, Integer> length = String::length;
    public static Function<String, Character> firstChar = str -> {
        if (str != null && str.length() > 0) {
            return str.charAt(0);
        }
        return null;
    };
    public static Function<String, Boolean> isNotSpace = str -> str.indexOf(' ') == -1;
    public static Function<String, Integer> countWords = str -> {
        StringBuilder sb = new StringBuilder(str);
        while (sb.charAt(0) == ',') {
            sb.deleteCharAt(0);
        }
        return sb.toString().split(",+").length;
    };
    public static Function<Human, Integer> getAge = Human::getAge;
    public static BiFunction<Human, Human, Boolean> isEqualLastName =
            (h1, h2) -> h1.getLastname().equals(h2.getLastname());
    public static Function<Human, String> getFullName =
            human -> human.getLastname() + " " + human.getFirstname() + " " + human.getMiddlename();
    public static Function<Human, Human> addYearToHuman =
            human -> new Human(human.getLastname(), human.getFirstname(), human.getMiddlename(), human.getAge() + 1,
                    human.getSex()
            );
    public static IOperation isAgesLowerMaxAges =
            (Human h1, Human h2, Human h3, int maxAge) -> h1.getAge() < maxAge && h2.getAge() < maxAge &&
                    h3.getAge() < maxAge;
}