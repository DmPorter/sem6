package lab4.zad4;

public abstract class Shape {
    private final Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void moveBy(double dx, double dy) {
        point.x += dx;
        point.y += dy;
    }

    public abstract Point getCenter();
}