package chapter5;

public class While01 {
    public static void main(String[] args){
        int i = 1; // 循环变量初始化
        while( i <= 10 ){
            System.out.println("ok" + i);
            i++;//循环变量迭代
        }
        System.out.println(i); //11
        System.out.println("退出while");
    }
}
