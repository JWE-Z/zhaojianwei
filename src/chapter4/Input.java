package chapter4;

// 从Scanner类所在的包导入类Scanner
import java.util.Scanner;
public class Input {
    public static void main(String[] args){
        // 创建 Scanner 对象， new创建一个对象
        Scanner myScanner = new Scanner(System.in);
        // 接受用户输入,使用相关方法
        System.out.println("请输入用户的名字");
        String name = myScanner.next();  // 接受用户输入
        System.out.println("请输入用户的年龄");
        int age = myScanner.nextInt();  // 接受用户输入
        System.out.println("请输入用户的薪水");
        double sal = myScanner.nextDouble();  // 接受用户输入
        System.out.println("用户信息如下");
        System.out.println("名字=" + name
                + " 年龄=" + age + " 薪水=" + sal);
    }
}
