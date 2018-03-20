public class Square extends Figure implements Print {
    private double sideA;
    private double sideB;

    public Square(double sideA, double sideB) {
        this.sideA=sideA;
        this.sideB=sideB;
    }
    public Square() {
        this(2.0,2.0);
    }

    public double getSideA() {
        return sideA;
    }
    public void setSideA(double sideA) {
        this.sideA=sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public void setSideB(double sideB) {
        this.sideB=sideB;
    }


    public  double calculateArea() {
        return sideA*sideB;
    }


    public double calculatePerimeter()
    {
        return 2*sideA+2*sideB;
    }

    public void print() {
        System.out.println("Characteristic data for the square: a="+sideA+", b="+sideB);
    }
}
