public class Triangle extends Figure implements Print {
    private double sideA,sideB,sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA+sideB >sideC && sideA+sideC >sideB && sideC+sideB >sideA)
        {

            this.sideA=sideA;
            this.sideB=sideB;
            this.sideC=sideC;
        }
        else
        {

            throw new IllegalArgumentException();
        }


    }
    public Triangle() {
        this(1.0, 2.0 ,3.0);
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
    public double getSideC() {
        return sideC;
    }
    public void setSideC(double sideC) {
        this.sideC=sideC;
    }


    public  double calculateArea() {
        double p=calculatePerimeter()/2;
        return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
    }


    public double calculatePerimeter() {
        return sideA+sideB+sideC;
    }

    public void print() {
        System.out.println("Characteristic data for the triangle: a="+sideA+", b="+sideB+", c="+sideC);

    }

}
