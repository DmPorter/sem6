package lab4.zad13;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args)
            throws Exception
    {
        print1(Math.class.getMethod("sqrt", double.class),  3, 15, 3);
        System.out.println();
        print1(Double.class.getMethod("toHexString", double.class),  3, 15, 3);
        System.out.println();
        print2(Math::sqrt, 1, 10, 1);
        System.out.println();
        print2(Double::toHexString, 1, 10, 1);

    }

    public static void print1(Method met, double lowlimit, double highlimit, double step)
            throws Exception {
        System.out.println(met.getName());

        System.out.println(met.getDeclaringClass().getSimpleName() + "." + met.getName() + "(double obj)");

        for (double val = lowlimit; val <= highlimit; val += step) {
            System.out.println(val + " " + met.invoke(null, val));
        }
    }

    public static void print2(DoubleFunction<Object> f, double lowerlimit, double highlimit, double step) {

        for (double val = lowerlimit; val <= highlimit; val += step) {
            System.out.println(val + " " + f.apply(val));
        }
    }
}