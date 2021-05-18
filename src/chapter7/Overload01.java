package chapter7;

public class Overload01 {
    public static void main(String[] args){
//        MyCalculator mc = new MyCalculator();
//        System.out.println(mc.calculate(1 , 2));
//        System.out.println(mc.calculate(1.1, 2));
        Methods methods = new Methods();
        System.out.println(methods.max(20, 24));
        System.out.println(methods.max(10.0, 24.0));
        System.out.println(methods.max(1.4, 10.0 , 30));
    }
}

class MyCalculator {
    public int calculate(int n1, int n2){//两个整数的和
        return n1 + n2;
    }
    public double calculate(int n1, double n2) { //一个整数，一个double 的和
        return n1 + n2;
    }
    public double calculate(double n2, int n1) {//一个double ,一个Int 和
        return n1 + n2;
    }
    public int  calculate(int n1, int n2,int n3) {//三个int 的和
        return n1 + n2 + n3;
    }
}

class Methods {
    /*
    定义三个重载方法max()，
    第一个方法，返回两个int 值中的最大值，
    第二个方法，返回两个double 值中的最大值，
    第三个方法，返回三个double 值中的最大值，
    并分别调用三个方法
     */
    public int max(int n1, int n2){
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2){
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2, double n3){
        return n1 > n2 ? (n1 > n3 ? n1 : n3) : (n2 > n3 ? n2 : n3);
    }
}

