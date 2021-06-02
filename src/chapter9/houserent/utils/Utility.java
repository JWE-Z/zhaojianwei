package chapter9.houserent.utils;

import java.util.Scanner;

public class Utility {
    private static Scanner  scanner = new Scanner(System.in);

    public static char readChar(){
        boolean loop = true;
        String key;
        do {
            key = scanner.next();
            if(key.length() == 1) {
                loop = false;
            } else {
                System.out.println("符号长度必须为1");
            }
        } while (loop);
        return key.charAt(0);
    }

    public static char readCharNum() {
        boolean loop = true;
        char charNum;
        do {
            charNum = Utility.readChar();
            if (charNum <= 57 && charNum >= 48) {
                loop = false;
            } else {
                System.out.println("输入必须为0 - 9数字");
            }
        } while (loop);
        return charNum;
    }

    public static String readString() {
        String st = scanner.next();
        return st;
    }

    /**
     * 功能：接受指定最大长度的String
     * @param maxLength 不指定最大长度时候不限制长度
     * @return
     */
    public static String readString(int maxLength) {
        String st = readString();
        if(st.length() > maxLength){
            System.out.println("输入长度大于" + maxLength + "程序自动截取前" + maxLength + "个字符" );
            return st.substring(0,maxLength);
        }
        return st;
    }

    public static String readString(int maxLength, String defaultValue){
        String s = readKeyBoard(maxLength, true);
        return "".equals(s)? defaultValue : s;
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    /**
     * 功能：接受指定最大长度的int
     * @param maxLength 不指定最大长度时候不限制长度
     * @return
     */
    public static int readInt(int maxLength) {
        return Integer.parseInt(readString(maxLength));
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }


    public static char readConfirmSelection(){
        System.out.print("请确认是否删除(Y/),请小心选择：");
        char c;
        for ( ; ;){ //无限循环
            String st = readString(1).toUpperCase();
            c = st.charAt(0);
            if( c == 'Y' || c == 'N'){
                break;
            } else {
                System.out.println("输入有误，请重新输入：");
            }
        }
        return c;
    }

    public static String readKeyBoard(int maxLength, boolean blankReturn){
        String line = "";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();

            if (line.length() == 0){
                if (blankReturn) return line;
                else continue;
            }

            if(line.length() > maxLength){
                System.out.println("输入长度不能大于" + maxLength + "，请重新输入：" );
                continue;
            }

            break;
        }
        return line;
    }



//    /**
//     * 功能：接受一个a到b的整数，类型为String，长度必须为1
//     * @ return 返回整数，类型为Char，整数范围0-9
//     */
//    public static char readCharNum(int a, int b){
//        Scanner scanner = new Scanner(System.in);
//        boolean loop = true;
//        String key;
//        if(a < 0 || a > 9 || b < 0 || b > 9){
//            return '错';
//        }
//        do {
//            key = scanner.next();
//            if(key.length() == 1){
//                if(a <= Integer.parseInt(key) && Integer.parseInt(key) <= b){
//                    loop = false;
//                } else {
//                    System.out.println("整数范围为" + a + " - " + b);
//                }
//            } else {
//                System.out.println("符号长度必须为1");
//            }
//        } while (loop);
//        return key.charAt(0);
//    }


}
