package lab4.zad10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[2];
        System.out.println(arr.getClass());
        printMethods("[I"); // int[] class
    }

    public static void printMethods(String className) {
        Class<?> cl = null;
        try {
            cl = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getCanonicalName()
                                + " " + m.getName() + Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}
