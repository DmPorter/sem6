package lab5.zad10;

public class Factor {
    public static  int factorial(int k) throws IllegalArgumentException{
        if (k == 0 | k == 1) {
            Exception e = new Exception("This is exception!" );
            e.printStackTrace(System.out);
            return 1;
        }
        return k * factorial(k-1);
    }
}