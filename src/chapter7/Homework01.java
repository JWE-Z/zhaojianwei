package chapter7;

public class Homework01 {
    public static void main(String[] args) {
        A01 a01 = new A01();
        double[] arrTest = {10 , 22,12.9, 100, -20};
        Double max = a01.max(arrTest);
        if(max != null){
            System.out.println(max);
        } else {
            System.out.println("数组无效,数组不能为null，且长度必须>0");
        }

    }
}

class A01{

    public Double max(double[] arr){  // 返回包装类 Double
        if(arr != null && arr.length > 0){
            double maxNumber = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(maxNumber < arr[i]){
                    maxNumber = arr[i];
                }
            }
            return maxNumber;  // 返回double类型
        } else {
            return null;  // 对象是可以为空的
        }
    }

}
