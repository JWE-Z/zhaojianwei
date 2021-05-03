package chapter1to3;
public class VarConvert_parc {
    public static void main(String[] args){
        short s = 12; // 默认的int常量可以根据范围赋值给byte，short，char
        byte b = 10; //ok
//        b = b + 11; //
        b = (byte) (b + 11);
        char c = 'a';
        int i = 16;
        float d = .314f;
        double result = c + i + d;
        byte k = 16;
        short j = 14;
//        short t = k + j;

    }
}
