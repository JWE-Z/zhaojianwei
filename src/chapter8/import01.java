package chapter8;

import java.util.Arrays;

public class import01 {
    public static void main(String[] args) {
     int[] arr = {-1, 20, 2, 13, 3};
        Arrays.sort(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");

        }
    }
}
