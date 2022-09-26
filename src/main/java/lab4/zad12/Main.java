package lab4.zad12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String STR = "jjkljkfdj8kjgkldshdgJDsh34f4dsj2flfjlzfkj819849304218237nfjsklw";
    private static final int ITERATIONS = 100_000_000;

    public static void main(String[] args) throws NoSuchMethodException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            STR.indexOf("484");
        }
        System.out.printf("%6s ms - regular method call\n", System.currentTimeMillis() - start);


        Method method = String.class.getMethod("indexOf", String.class);
        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            try {
                method.invoke(STR, "484");
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%6s ms - a method call via reflection\n", System.currentTimeMillis() - start);
    }
}
