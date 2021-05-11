package chapter6;

public class BubbleSort {
    // 冒泡排序
    public static void main(String[] args) {
//        int[] arr = {24, 69, 80, 57, 13, -1, 30, 200, -11};
//        int[] arr = {1, 2, 3, 4};
        int[] arr = {-1, 30, -11, 200};
        for(int i = arr.length - 1; i > 0; i--) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (temp == 0) {
                break;
            }

            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("排序最终结果");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
    }
}
