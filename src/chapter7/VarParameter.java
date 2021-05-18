package chapter7;

public class VarParameter {
    public static void main(String[] args){
        HspMethod m = new HspMethod();
        System.out.println(m.sum(1, 5, 100)); //106
        System.out.println(m.showScore("Daming", 90, 80, 85));
    }
}

class HspMethod{
    public int sum(int... nums){
        System.out.println(nums.length);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        return res;
    }

    public String showScore(String name, double... scores){
        double res = 0;
        for(int i = 0; i < scores.length; i++){
            res += scores[i];
        }
        return name + "一共有" + scores.length +  "门课，总成绩为:" + res;
    }
}
