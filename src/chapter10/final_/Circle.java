package chapter10.final_;

public class Circle {
    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
//        PI = 3.14;
    }

    {
//        PI = 3.14
    }

    public double calArea(){
        return PI * radius * radius;
    }
}
