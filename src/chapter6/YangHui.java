package chapter6;

public class YangHui {
    public static void main(String[] args){
        // 打印杨辉三角形
        int[][] yangHui = new int[10][];
        for(int i = 0; i < yangHui.length; i++){
            yangHui[i] = new int[i+1];
            for(int j = 0; j < yangHui[i].length; j++){
                if(j == 0 || j == yangHui[i].length -1){
                    yangHui[i][j] = 1;
                } else {
                    yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
                }
            }
        }
        for(int i = 0; i < yangHui.length; i++) {
            for(int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
