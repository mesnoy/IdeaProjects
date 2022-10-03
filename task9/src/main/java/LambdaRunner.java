import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LambdaRunner {
    public static <T, R> R biFunction(Function<T, R> function, T obj) {
        return function.apply(obj);
    }

    public static <T, V, R> R tripleFunction(BiFunction<T, V, R> biFunction, T obj1, V obj2) {
        return biFunction.apply(obj1, obj2);
    }

    public static boolean iOperation(IOperation function, Human h1, Human h2, Human h3, int maxAge) {
        return function.apply(h1, h2, h3, maxAge);
    }
}