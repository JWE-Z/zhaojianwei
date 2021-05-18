package chapter7;

public class Recursion {
    public static void main(String[] args){
//        int n = 7;
//        T calFi = new T();
//        System.out.println(n + "的斐波那契数为" + calFi.cal(n));

        int day = 1;
        T calPeach = new T();
        System.out.println("第" + day + "天的桃子数目为" + calPeach.peach(day));

    }
}

class T{
    public int Fibonacci(int n){
        if(n >= 1){
            if(n == 1 || n == 2){
//                System.out.println(1);
                return 1;
            } else {
                int a = Fibonacci(n-1) + Fibonacci(n-2);
//                System.out.println(a);
                return a;
            }
        } else {
            System.out.println("请输入大于等于1的数");
            return -1;
        }
    }


    public int peach(int day){
    /*
    猴子吃桃子问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
    以后每天猴子都吃其中的一半，然后再多吃一个。当到第10 天时，
    想再吃时（即还没吃），发现只有1 个桃子了。问题：最初共多少个桃子？
     */
        if(day == 10){
            return 1;
        } else if (day >= 1 && day <= 9){
            return (peach(day + 1) + 1) * 2;
         } else {
            System.out.println("错误，day在1-10");
            return -1;
        }
    }
}




