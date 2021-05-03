package chapter4;

public class TernaryOper {
    public static void main(String[] args){
        int a = 10;
        int b = 99;
        int result = a > b ? a++ : b--;
        System.out.println(result);// 99
        System.out.println(a);// 10
        System.out.println(b);// 98
        b = 99;
        int results = a > b ? a++ : --b;
        System.out.println(results); //98

        // 实现三个数中最大的数
        int n1= 555;
        int n2 = 33;
        int n3 = 123;
        int max1 = n1 > n2 ? n1 : n3;
        int max2 = max1 > n3 ? max1 : n3;
        System.out.println("最大的数为"+ max2);


    }
}
