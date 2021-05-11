package chapter5;

import java.util.Scanner;
public class BreakExercise {
    public static void main(String[] args) {
        //实现登录验证，有3 次机会，如果用户名为"丁真" ,密码"666"提示登录成功，
        //否则提示还有几次机会，请使用for+break 完成
        Scanner myScanner = new Scanner(System.in);
        String name = "";
        String passwd = "";
        int chance = 3;//登录一次少一次
        for(int i = 1; i <= 3; i++){
            System.out.println("请输入用户名");
            name = myScanner.next();
            System.out.println("亲输入您的密码");
            passwd = myScanner.next();
            if("丁真".equals(name) && "666".equals(passwd)){
                System.out.println("登录成功");
                break;
            } else {
                chance--;
                System.out.println("你还有" + chance + "次登录机会");
            }
        }

    }
}
