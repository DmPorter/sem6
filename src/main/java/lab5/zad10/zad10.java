package lab5.zad10;

public class zad10 {
    public static void main(String[] args) {
        try{
            System.out.println(Factor.factorial(10));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}