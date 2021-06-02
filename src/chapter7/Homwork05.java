package chapter7;

public class Homwork05 {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        double circumference = circle.circumference();
        double area = circle.area();
        System.out.println(circumference);
        System.out.println(area);
    }
}

class Circle{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    Circle(){}

    public double circumference(){
        return 2 * Math.PI * radius;
    }

    public double area(){
        return Math.PI * Math.pow(radius,2);
    }
}




