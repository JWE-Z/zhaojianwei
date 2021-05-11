package chapter6;

public class Array01 {
    public static void main(String[] args){
        // 数组简单示例
        // 定义一个double数组, 静态初始化
        double[] hens = {3, 5, 1, 3.4, 2, 50};
        // 遍历数组的所有元素 hens[0], hens[1], ...
        double totalweight = 0;
        for (int i = 0; i < hens.length; i++){
//            System.out.println("hens[" +i + "]=" + hens[i]);
            totalweight += hens[i];
        }
        System.out.println("totalweight: " + totalweight);
    }
}