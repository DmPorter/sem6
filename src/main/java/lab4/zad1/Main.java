package lab4.zad1;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(2.0, 1.0);
        Point p3 = new Point(2.0, 1.0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));

        LabeledPoint lp1 = new LabeledPoint("p1", 1.0, 2.0);
        LabeledPoint lp2 = new LabeledPoint("p1", 2.0, 1.0);
        LabeledPoint lp3 = new LabeledPoint("p1", 1.0, 2.0);

        System.out.println(lp1);
        System.out.println(lp2);

        System.out.println(lp1.equals(p1));
        System.out.println(lp2.equals(lp1));
        System.out.println(lp3.equals(lp1));

        System.out.println(p3.equals("adhsgfj"));
    }
}

