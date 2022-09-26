package lab4.zad11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.System");
        Field field = clazz.getDeclaredField("out");
        field.getType().getMethod("println", String.class)
                .invoke(field.get(null), "Hello, World");
    }
}