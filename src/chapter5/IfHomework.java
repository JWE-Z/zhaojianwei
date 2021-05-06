package chapter5;

import java.util.Scanner;

public class IfHomework {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输如当前月份（int，1-12）");
        int month = myScanner.nextInt();
        System.out.println("请输如您的年龄（int，>0）");
        int age = myScanner.nextInt();
        if (month >= 4 && month <= 10) {
            System.out.println("现在是旺季！");
            if (age > 60) {
                System.out.println("老人票 20 元");
            } else if (age < 18) {
                System.out.println("儿童票 30 元");
            } else {
                System.out.println("成人票 60 元");
            }
        } else {
            System.out.println("现在是淡季！");
            if(age > 18 && age < 60){
                System.out.println("成人票 40 元");
            } else {
                System.out.println("半价票 20 元");
            }
        }

    }
}

