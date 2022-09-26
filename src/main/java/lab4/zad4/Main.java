package lab4.zad4;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1.0,2.0), 1);
        System.out.println(c1.getCenter());
        Circle c2 = c1.clone();
        System.out.println(c1 == c2);

        Line l1 = new Line(new Point(0.0, 0.0), new Point(10.0, 10.0));
        System.out.println(l1.getCenter());

        Rectangle r1 = new Rectangle(new Point(2.0,2.0), 2, 2);
        System.out.println(r1.getCenter());
    }
}