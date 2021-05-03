package chapter1to3;
public class FloatDetail {
    public static void main(String[] args){
        float num1 = 1.1f;
        double num11 = 2.7;
        double num12 = 8.1 / 3;
        System.out.println(num11);
        System.out.println(num12);
        // 错误的写法
        if (num11 == num12){
            System.out.println("相等");
        }
        //正确的写法
        if(Math.abs(num11 - num12) < 0.0001){
            System.out.println(Math.abs(num11 - num12));
            System.out.println("差值小于设定精度认为相等");

        }
    }
}
