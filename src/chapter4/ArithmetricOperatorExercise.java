package chapter4;

public class ArithmetricOperatorExercise {
    public static void main(String[] args){
        // 59天转化为几周零几天
        int day = 59;
        int weeks = day/7;
        int days = 59%7;
        System.out.println(weeks + " + " +days);


        // 华氏温度转摄氏温度
        double hs = 234.6;
        double se = 5.0 / 9 * (hs-100);
        System.out.println("华氏温度" + hs + "等于摄氏温度" + se);


    }
}
