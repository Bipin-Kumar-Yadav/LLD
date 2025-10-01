package SOLID.ISP;

interface TwoDShape{
    double area();
}
interface ThreeDShape{
    double area();
    double volume();
}
class Square implements TwoDShape{
    private double side;
    public Square(double side){
        this.side = side;
    }
    public double getSide(){
        return side;
    }
    @Override
    public double area(){
        return side * side;
    }
}
class Rectangle implements TwoDShape{
    private double length,width;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    @Override 
    public double area(){
        return length * width;
    }
}

class Cube implements ThreeDShape{
    private double side;
    public Cube(double side){
        this.side = side;
    }
    public double getSide(){
        return side;
    }
    @Override
    public double area(){
        return 6 * side * side;
    }
    @Override
    public double volume(){
        return side * side * side;
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        TwoDShape square = new Square(4);
        TwoDShape rectangle = new Rectangle(4, 3);
        ThreeDShape cube = new Cube(6);

        System.out.println("Area of Square: " + square.area());
        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Cube: " + cube.area());
        System.out.println("Volume of Cube: " + cube.volume());
    }
}
