package chapter5;

public class ForExercise01 {
    public static void main(String[] args){
        //打印1~100 之间所有是9 的倍数的整数，统计个数及总和
        int count = 0;
        int sum = 0;
        int start  = 1;
        int end = 100;
        int t = 5;
        for(int i = start; i <= end; i++){
            if(i % t == 0){
                System.out.println(i);
                count++;
                sum += i;
            }
        }
        System.out.println("满足条件的个数为" + count);
        System.out.println("满足条件数字和为" + sum);
    }
}
