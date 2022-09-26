package lab4.zad4;

public class Circle extends Shape implements Cloneable{
    private final double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }
    @Override
    public Circle clone(){
        return new Circle(new Point(getPoint().getX(), getPoint().getY()), radius);
    }
    @Override
    public Point getCenter() {
        return getPoint();
    }
}