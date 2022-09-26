package lab4.zad4;

public class Line extends Shape implements Cloneable{
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        super(new Point((from.x + to.x)/2, (from.y + to.y)/2));
        this.from = from;
        this.to = to;
    }

    @Override
    public Line clone(){
        return new Line(new Point(from.getX(), from.getY()), new Point(to.getX(), to.getY()));
    }
    @Override
    public Point getCenter() {
        return getPoint();
    }
}
