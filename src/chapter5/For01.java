package chapter5;

public class For01 {
    public static void main(String[] args){
        // 循环基本结构
        for( int i = 1; i <= 10; i++){
            System.out.println("test"+i);
        }
//        System.out.println(i); //会报错，没有i这个变量

        //for( ; 循环判断条件 ; ) 中的初始化和变量迭代可以写到其它地方，但是两边的分号不能省略。
        // 在for循环前面，外边的初始化变量在循环结束后仍然可以用（作用域不再局限在循环内部）
        int j = 1;
        for ( ; j<= 10 ; ){
            System.out.println("test"+j);
            j++;
        }
        System.out.println(j); // 11

        // 循环初始值可以有多条初始化语句，但要求类型一样，并且中间用逗号隔开，
        // 循环变量迭代也可以有多条变量迭代语句，中间用逗号隔开。
        for(int i = 1, k = 1; i <= 10; i++, j+=2){
            System.out.println("i=" + i + "k=" + k);
        }

        // 死循环
        for(;;){
            System.out.println("ok");
        }
    }
}