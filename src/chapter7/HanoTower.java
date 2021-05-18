package chapter7;

public class HanoTower {
    public static void main(String[] args){
        HT tower = new HT();
        tower.move(2, 'A', 'B', 'C');
    }
}

class  HT {
    // num 表示要移动的个数；
    // a,b,c表示A塔B塔C塔;
    public void move(int num, char a, char b, char c){
        if(num == 1){
            System.out.println(a + "->" + c);
        } else {
            // 如果有多个盘，可以看成两个, 最下面的和上面的所有盘(num-1)
            // (1)先移动上面所有的盘到b, 借助c
            move(num -1, a, c, b);
            // (2)把最下面的这个盘，移动到c
            System.out.println(a + "->" + c);
            // (3)再把b 塔的所有盘，移动到c ,借助a
            move(num - 1, b, a, c);
        }
    }

}