package chapter6;

import java.util.Scanner;
public class Array02    {
    public static void main(String[] args){
        // 数组使用，动态初始化用法1
        double scores[] = new double[5];
//        double[] scores = new double[5] // 与上面等价
        // 数组使用，动态初始化用法2
         double a[]; // a 是null
        // double[] a;
        a = new double[5];

        Scanner myScanner = new Scanner(System.in);
        for(int i = 0; i < scores.length; i++){
            System.out.println("输入第" + (i+1) + "个元素的值");
            scores[i] = myScanner.nextDouble();
        }
        for(int i = 0; i < scores.length; i++){
            System.out.println("第" + (i+1) + "个元素的值为" + scores[i]);
        }
    }
}
