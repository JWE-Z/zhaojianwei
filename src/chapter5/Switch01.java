package chapter5;

import java.util.Scanner;
public class Switch01 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入一个字符");
        char c1 = myScanner.next().charAt(0);
        switch(c1){
            case 'a':
                System.out.println("今天周一");
                break;
            case 'b':
                System.out.println("今天周二");
                break;
            case 'c':
                System.out.println("今天周三");
                break;
            default:
                System.out.println("输入不匹配");
        }
        System.out.println("退出switch");
    }
}
