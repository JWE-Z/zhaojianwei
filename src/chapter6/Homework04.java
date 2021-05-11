package chapter6;

public class Homework04 {
    public static void main(String[] args){
        // 升序数组，插入一个数后仍然为升序
        int[] arr = {10, 12, 45, 90};
        int insertNum = 100;
        int index = arr.length;
        for(int i = 0; i < arr.length; i++){
            if(insertNum < arr[i]){
                index = i;
                break;
            }
        }
        System.out.println("应该插入的index:"+ index);
        int[] newArr = new int[arr.length + 1];
        for(int j = 0, i = 0; j < newArr.length; j++){
            if(index != j){
                newArr[j] = arr[i];
                i++;
            } else {
                newArr[j] = insertNum;
            }
        }
        arr = newArr;

        System.out.println("============扩容后============");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }
}
