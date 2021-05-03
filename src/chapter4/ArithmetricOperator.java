package chapter4;

/**
 * 演示算术运算符的使用
 */
public class ArithmetricOperator {
    public static void main(String[] args){
        // \ 除号
        System.out.println(10 / 4); //从数学来看是2.5, java int/int 还是int，所以是2, 只保留整数部分
        System.out.println(10.0 / 4); //2.5， 保留小数
        double d = 10 / 4; //java 中10 / 4 = 2, 2=>2.0
        System.out.println(d);// 是2.0

        // % 取模 ,取余
        // 在 % 的本质 看一个公式!!!! a % b = a - a / b * b
        // -10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1
        // 10 % -3 = 10 - 10 / (-3) * (-3) = 10 - 9 = 1
        // -10 % -3 = (-10) - (-10) / (-3) * (-3) = -10 + 9 = -1
        System.out.println(10 % 3); //1
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); //1
        System.out.println(-10 % -3);//-1

        //++的使用
        // 独立使用
        int i = 10;
        i++;//自增 等价于 i = i + 1; => i = 11
        ++i;//自增 等价于 i = i + 1; => i = 12
        System.out.println("i=" + i);//12
        /*
        作为表达式使用
        前++：++i 先自增后赋值
        后++：i++先赋值后自增
         */
        int j=8;
//        int k = ++j;  //等价 j=j+1;k=j;  k = j = 9
        int k = j++; // 等价 k =j;j=j+1; k = 8, j = 9
        System.out.println("k=" + k + "j=" + j);//8 9

        // 经典面试题目
         int ii = 1;//i->1
         ii = ii++; //规则使用临时变量: (1) temp=i;(2) i=i+1;(3)i=temp;
         System.out.println(ii); // 1

         int jj=1;
         jj=++jj; //规则使用临时变量: (1) i=i+1;(2) temp=i;(3)i=temp;
         System.out.println(jj); //2


    }
}
