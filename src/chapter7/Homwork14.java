package chapter7;

import java.util.Random;

public class Homwork14 {
    public static void main(String[] args) {

    }
}

class Tom{
    int tomGussNum;
    int pcGussNum;
    int winCountNum;
    int count = 1;

    public int pcNum(){
        Random r = new Random();
        pcGussNum = r.nextInt(3); // 返回0-3随机数
        return pcGussNum;
    }




}
