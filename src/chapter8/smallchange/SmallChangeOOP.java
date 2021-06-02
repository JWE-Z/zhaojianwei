package chapter8.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
    boolean loop = true;
    int key;
    double money;
    double balance;
    String note;
    String details = "===================零钱通明细=================";;
    Scanner scanner = new Scanner(System.in);
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 用于时间格式化

    public void mainMenu(){
        do{
            System.out.println("\n===================零钱通系统=================");
            System.out.println("\t\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t\t2. 收益入账");
            System.out.println("\t\t\t\t3. 消费");
            System.out.println("\t\t\t\t4. 退出");
            System.out.println("请选择（1-4）");
            key = scanner.nextInt();
            switch(key){
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.pay();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误");
            }
        } while (loop);

    }

    public void income(){
        System.out.println("收入金额(>0)：");
        money = scanner.nextDouble();
        if(money <= 0 ){
            System.out.println("收入金额>0");
            return;
        }
        balance += money;
        date = new Date(); // 获取当前时间
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t";
    }

    public void pay(){
        System.out.println("花费金额：金额范围在0-" + balance);
        money = scanner.nextDouble();
        if(money <= 0 || money > balance){
            System.out.println("金额范围在0-" + balance);
            return;
        }
        System.out.println("花费项目：");
        note = scanner.next();
        balance -= money;
        date = new Date(); // 获取当前时间
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t";
    }

    public void exit(){
//        do{
//            System.out.println("你确定退出吗？y/n");
//            String confirm = scanner.next();
//            if("y".equals(confirm)){
//                loop = false;
//                System.out.println("================零钱通退出=================");
//                break;
//            } else if ("n".equals(confirm)){
//                break;
//            }
//        }while (true);

        String confirm;
        do{
            System.out.println("你确定退出吗？y/n");
            confirm = scanner.next();
            if("y".equals(confirm) || "n".equals(confirm)){
                break;
            }
        } while (true);

        if ("y".equals(confirm)){
            loop = false;
            System.out.println("================零钱通退出=================");
        }
    }
}
