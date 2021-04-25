public class AutoConvert {
    public static void main(String[] args){
        int a = 'a';
        double b = 89;
        System.out.println(a);
        System.out.println(b);
        int n1 = 10;
        float d1 = n1 + 1.1f;
        double d2 = n1 + 1.1;
        byte b1 = 10;
        int n2 = 1;
//        byte b2 = n2;  错误
        byte b2 = 1;
        byte b3 = 2;
        short s1 = 1;
        //short s2 = b2 + s1;//错, b2 + s1 => int
        int s2 = b2 + s1;//对, b2 + s1 => int
//        byte b4 = b2 + b3;
        byte b4 = 1;
        short s3 = 100;
        int num200 = 1;
        float num300 = 1.1F;
        double num500 = b4 + s3 + num200 + num300; //float -> double
    }
}
