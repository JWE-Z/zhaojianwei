package chapter7;

public class Homwork13 {
    public static void main(String[] args) {
        PassObject passObject = new PassObject();
        Circle circle = new Circle();
        passObject.printAreas(circle, 5);

    }
}


class PassObject{
    public void printAreas(Circle c, int times){
        for (int i = 1; i < times+1; i++) {
            c.radius = i;
            System.out.println("半径为：" + c.radius + "\t圆的面积为：" + c.area());

        }

    }
}
