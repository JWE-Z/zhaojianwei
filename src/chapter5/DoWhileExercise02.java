package chapter5;

import java.util.Scanner;
public class DoWhileExercise02 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        char answer = ' ';
        do{
            System.out.println("你还钱吗？y/n");
            answer = myScanner.next().charAt(0);
            System.out.println("你的回答是" + answer);
        }while(answer == 'n');
    }
}
