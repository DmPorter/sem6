package lab4.zad9;

import lab4.zad4.Point;
import lab4.zad4.Rectangle;

public class Main {
    public static void main(String[] args) throws Exception {
        Rectangle rectangle = new Rectangle(new Point(1, 1), 100, 50);


        System.out.println(MyToString.myToString(rectangle));
        System.out.println(MyToString.myToString(new Point[]{new Point(1,2), new Point(2, 2), new Point(3, 3)}));

        System.out.println(MyToString.myToString(2));

        System.out.println(MyToString.myToString(new int[]{1,2,3,4}));

    }




}