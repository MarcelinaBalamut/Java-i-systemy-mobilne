package sample;

public class Point {
    double x;
    double y;
    boolean inside;
    private int counter;

    public Point(double x, double y, boolean inside, int counter) {
        this.x = x;
        this.y = y;
        this.inside = inside;
        this.counter=counter;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isInside() {
        return inside;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}