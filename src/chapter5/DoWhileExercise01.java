package chapter5;

public class DoWhileExercise01 {
    public static void main(String[] args){
        int i = 1;
        int sum = 0;
        do{
            System.out.println(i);
            sum += i;
            i++;
        } while(i <= 100);
        System.out.println("sum:"+sum);


        // 统计1-200之间可以 被5整除不能被3整除的数的个数
        int j = 1;
        int count = 0;
        do{
            if(j % 5 == 0 && j % 3 != 0){
                System.out.println(j);
                count++;
            }
            j++;
        } while(j <= 200);
        System.out.println("count:" + count);
    }
}
