package chapter5;

public class DoWhile01 {
    public static void main(String[] args){
        // 输出10句你好
        int i = 1;
        do {
           System.out.println("你好" + i);
           i++;
        } while(i <= 10);
    }
}
