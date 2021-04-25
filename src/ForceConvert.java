public class ForceConvert {
    public static void main(String[] args){
        int n1 = (int)1.9;
        System.out.println("n1="+n1);  //1 精度损失
        int n2 = 2000;
        byte b1 = (byte)n2;
        System.out.println("b1="+b1);//-48  数据溢出
//        int x = (int)10*3.5 + 6*1.5;
        int x = (int)(10*3.5 + 6*1.5);
        System.out.println(x);

        char c1 = 100; //ok
        int m = 100; //ok
        //char c2 = m; //错误
        char c3 = (char)m; //ok
        System.out.println(c3);//100 对应的字符, d 字符

    }
}
