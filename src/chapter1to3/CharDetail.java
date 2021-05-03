package chapter1to3;
public class CharDetail {

    public static void main(String[] args){
        char c1 = 'a';
        char c2 = '\t';
        char c3 = '韩';
        char c4 = 97;  // 字符类型可以直接存放数字，表示数字97代表的那个字符
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println((int)c1);  // 将字符a输出为对应的数字
        System.out.println((int)c3);  // 将字符a输出为对应的数字
        char c5 = 38889;
        System.out.println(c5);  // 将字符数字输出为字符
        System.out.println('a'+10);  // 97+10=107
        char c6 = 'b' + 1;
        System.out.println((int)c6); // 99
        System.out.println(c6); //c
    }
}
