// 转义符使用

/**
 * @author JWE
 * @version 1.0
 */

public class ChangeChar {
    public static void main(String[] args) {
//      \t ：一个制表位，实现对齐的功能
        System.out.println("北京\t天津\t上海");
//      \n ：换行符
        System.out.println("zhao\nqian\nsun");
        /*
        zhao
        qian
        sun
         */
//      \\ ：一个\
        System.out.println("c:\\windows\\system32");
//      \" :一个"
        System.out.println("老王说：\"今天天气不错\"");
        //\' ：一个'
        System.out.println("老王说：\'今天天气不错\'");
//      \r :一个回车
        System.out.println("韩顺平教育\r\n北京");
        /*
        韩顺平教育
        北京
         */
//       课堂联系:
        System.out.println("书名\t作者\t\t价格\t销量\r\n三国\t罗贯中\t120\t1000");
        /*
        书名	作者		价格	销量
        三国	罗贯中	120	1000
         */
    }
}
