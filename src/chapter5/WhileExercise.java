package chapter5;

public class WhileExercise {
    public static void main(String[] args){
        //打印1—100 之间所有能被3 整除的数
        int i = 1;
        while( i <= 100 ){
            if(i % 3 == 0){
                System.out.println(i);
            }
            i++;
        }


        System.out.println("==================");
        //打印40—200 之间所有的偶数[使用while, 课后练习]
        int j = 40;
        while( j <= 200){
            if( j % 2 == 0){
                System.out.println(j);
            }
            j++;
        }
    }
}
