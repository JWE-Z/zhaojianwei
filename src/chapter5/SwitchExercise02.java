package chapter5;

import java.util.Scanner;
public class SwitchExercise02 {
    public static void main(String[] args) {
        //对学生成绩大于60 分的，输出"合格"。低于60 分的，
        //输出"不合格"。(注：输入的成绩不能大于100)
        //思路分析
        //1. 这道题，可以使用分支来完成， 但是要求使用switch
        //2. 这里我们需要进行一个转换, 编程思路:
        //      如果成绩在[60,100] , (int)(成绩/60) = 1
        //      如果成绩在[0,60) , (int)(成绩/60) = 0
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入您的成绩");
        double score = myScanner.nextDouble();
        if(score >= 0 && score <= 100){
            switch((int)(score/60)){
                case 0:
                    System.out.println("不及格");
                    break;
                case 1:
                    System.out.println("合格");
                    break;
//                default:
//                    System.out.println("输入有误");
            }
        } else {
            System.out.println("输入有误");
        }
    }
}
