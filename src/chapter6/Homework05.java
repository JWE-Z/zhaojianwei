package chapter6;

public class Homework05 {
    public static void main(String[] args){
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 100) + 1;
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        double sum = 0;
        int max = -1;
        int index = -1;
        int ind8 = -1;
        System.out.println("======倒序打印=====");
        for(int j = arr.length - 1; j >= 0; j--){
            System.out.print(arr[j] + "\t");
            if(arr[j] > max){
                max = arr[j];
                index = j;
            }
            if(arr[j] == 8){
                ind8 = j;
            }
            sum += arr[j];
        }
        System.out.println();
        System.out.println("最大值为：" + max + "\t其下标为：" + index);
        System.out.println("平均值为：" + sum/arr.length);
        if(ind8 != -1){
            System.out.println("在数组中可以找到数值8，其下标序号为：" + ind8);
        } else {
            System.out.println("在数组中没有找到数值8");
        }
    }
}
