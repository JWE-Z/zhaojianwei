package chapter7;

public class Homwork02 {
    public static void main(String[] args) {
        String[] arr = {"akg", "sony", "sennheiser", "bose"};
        String st = "beats";
        A02 a02 = new A02();
        int index = a02.find(st, arr);
        System.out.println(index);
    }
}


class A02{
    public int find(String st, String[] arr){
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(st)){
                index = i;
                break;
            }
        }
        return index;
    }

    public int find2(String st, String[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(st)){
                return i;
            }
        }
        return -1;
    }
}