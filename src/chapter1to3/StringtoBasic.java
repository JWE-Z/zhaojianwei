
package chapter1to3;
public class StringtoBasic {
    public static void main(String[] args){
        // 基本数据类型转为string

        int n1 = 100;
        float f1 = 1.1f;
        double d1 = 4.5;
        boolean b1 = true;
        String s1 = n1 + ""; //将int转化为string
        String s2 = f1 + "";
        String s3 = d1 + "";
        String s4 = b1 + "";
        System.out.println(s1 + " " + s2 + " " + s3 + " " + s4 + " ");

        // string转为基本数据类型
        // 调用相应的parse
        String s5 = "123";
        int num1 = Integer.parseInt(s5);  //123
        double num2 = Double.parseDouble(s5); //123.0
        float num3 = Float.parseFloat(s5); //123.0
        long num4 = Long.parseLong(s5);//123
        short num5 = Short.parseShort(s5);//123
        byte num6 = Byte.parseByte(s5);//123
        boolean num7 = Boolean.parseBoolean("true");//true
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(num7);

        System.out.println("=========================");
        // String 转化为 char， s5.charAt(n) 将字符串的第n+1个字符返回
        System.out.println(s5.charAt(1));  //2
    }
}
