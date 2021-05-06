package chapter5;

public class IfExercise01 {
    public  static  void main(String[] args){
        double d1 = 34.5;
        double d2 = 2.6;
        if(d1>10.0 && d2<20.0){
            System.out.println(d1+d2);
        }
        int n1 = 5;
        int n2 = 6;
        if((n1+n2)%3 == 0 && (n1+n2)%5 == 0){
            System.out.println("ok");
        } else {
            System.out.println("NO");
        }
        int year = 2020;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("瑞年");
        } else {
            System.out.println("不是");
        }
    }
}
