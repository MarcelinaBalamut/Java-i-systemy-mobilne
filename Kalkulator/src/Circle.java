import java.util.Scanner;

public class Circle extends Figure implements  Print {
    private double radius;

    public Circle( double radius) {
        this.radius=radius;
    }
    public Circle() {
        this(1.0);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius=radius;
    }

    public  double calculateArea() {
        return Math.PI*radius*radius;
    }


    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }

    public void print() {
        System.out.println("Characteristic data for the circle: radius="+radius);
    }


    }

