package chapter7;

public class Homwork06 {
    public static void main(String[] args) {
        Cale cale = new Cale(10, 4);
        System.out.println(cale.sum() + " " + cale.diff() + " " + cale.mul() + " " + cale.divide());
        Cale cale1 = new Cale(20, 0);
        System.out.println(cale1.sum() + " " + cale1.diff() + " " + cale1.mul() + " " + cale1.divide());

    }
}

class Cale{
    double num1;
    double num2;

    Cale (double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    Cale(){}

    public double sum(){
        return num2 + num1;
    }

    public double diff(){
        return num1 - num2;
    }

    public double mul(){
        return num2 * num1;
    }

    public Double divide(){
        if (num2 == 0){
            System.out.println("除数为0");
            return null;
        } else {
            return num1 / num2;
        }

    }
}