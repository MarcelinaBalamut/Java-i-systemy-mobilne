import java.util.InputMismatchException;
import java.util.Scanner;

public class FigureTest {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Figure figure;
        Print ifigure;


        System.out.println("Choose a figure:");
        System.out.println();
        System.out.println("1-Circle, 2-Square, 3-Trangle, q-Exit");

        while(input.hasNextInt()) {
            int n = input.nextInt();

            switch (n) {
                case 1:
                    System.out.println("You chose the circle, enter the radius");
                    try {

                         double radius = input.nextDouble();
                         if(radius>0) {
                             Circle circle = new Circle(radius);
                             figure = circle;
                             ifigure = circle;

                             ifigure.print();
                             System.out.println("Area= " + figure.calculateArea() + " Perimeter= " + figure.calculatePerimeter());
                         }
                         else
                             System.out.println("You put minus number");
                    }
                    catch(InputMismatchException e)
                    {
                        System.err.println("Wrong data format");
                    }

                    break;

                case 2:
                    System.out.println("You chose the square, enter the sides");
                    try {

                        double a = input.nextDouble();
                        double b = input.nextDouble();
                        if(a>0 && b>0)
                        {

                            Square square = new Square(a, b);
                            figure = square;
                            ifigure = square;

                            ifigure.print();
                            System.out.println("Area: " + figure.calculateArea() + " Perimeter= " + figure.calculatePerimeter());
                        }
                        else
                            System.out.println("You put minus number");
                    }
                    catch(Exception e)
                    {
                        System.err.println("Wrong data format");

                    }

                    break;
                case 3:
                    System.out.println("You chose the triangle, enter the sides ");
                    try {


                        double sideA = input.nextDouble();
                        double sideB = input.nextDouble();
                        double sideC = input.nextDouble();




                        try {
                            if(sideA>0 && sideB>0 && sideC>0) {
                                Triangle triangle = new Triangle(sideA, sideB, sideC);
                                figure = triangle;
                                ifigure = triangle;

                                ifigure.print();
                                System.out.println("Area: " + figure.calculateArea() + " Perimeter= " + figure.calculatePerimeter());
                            }
                            else
                                System.out.println("You puy minus number");
                        }
                        catch( IllegalArgumentException w)
                        {
                            System.err.println("Can't create a triangle");
                        }


                    }
                    catch(Exception e)
                    {
                        System.err.println("Wrong data format");
                    }
                    break;

                default:
                    System.out.println("Bad number");
                    break;

            }

        }


    }
}
