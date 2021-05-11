package chapter5;

import java.util.Scanner;

public class MulForExercise01 {
    public static void main(String[] args){
//        统计3个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
//        统计三个班及格人数，每个班有5名同学。
        Scanner myScanner = new Scanner(System.in);
        double totalScore = 0;
        int passNum = 0;
        for (int i = 1; i <= 3; i++){
            double sum = 0;
            for(int j = 1; j <= 5; j++){
                System.out.println("请输入第" + i + "个班第" + j + "个同学的成绩");
                double score = myScanner.nextDouble();
                System.out.println("该同学的成绩:" + score);
                sum += score;
                if(score >= 60){
                    passNum++;
                }
            }
            System.out.println("第" + i + "个班的平均分为：" + (sum / 5));
            totalScore += sum;
        }
        System.out.println("三个班的平均分为：" + (totalScore / 15));
        System.out.println("三个班的及格人数为：" + passNum);
    }
}
