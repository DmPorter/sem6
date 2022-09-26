package lab4.zad4;

public class Rectangle extends Shape implements Cloneable{
    private final double width;
    private final double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.height = height;
        this.width = width;
    }

    @Override
    public Rectangle clone(){
        return new Rectangle(new Point(super.getPoint().getX(), super.getPoint().getY()), width, height);
    }
    @Override
    public Point getCenter() {
        return new Point(super.getPoint().getX() + width / 2, super.getPoint().getY() - height / 2);
    }
}