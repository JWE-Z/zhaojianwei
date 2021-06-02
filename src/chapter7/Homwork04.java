package chapter7;

import java.util.Arrays;

public class Homwork04 {
    public static void main(String[] args) {
        String[] arr1 = {"akg", "sony", "sennheiser", "bose"};
        int arr2[] = {1,2,3,4};
        A03 a03 = new A03();
        String[] strings = a03.copyArr(arr1);
        int[] ints = a03.copyArr(arr2);
        for (String a:strings) {
            System.out.println(a);
        }
        System.out.println(Arrays.toString(ints));
    }
}

class A03{
    public int[] copyArr(int[] arr){
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public String[] copyArr(String[] arr){
        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    // ...
}