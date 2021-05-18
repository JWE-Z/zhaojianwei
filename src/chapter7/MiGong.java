package chapter7;

public class MiGong {
    public static void main(String[] args){
        // 用二维数组创建地图，0可以走，1不可以走
        int[][] map = new int[8][7];
        for(int i = 0; i < 7; i++){ // 第一行和最后一行设置为1
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for(int j = 1; j < 7; j++){ // 第一列和最后一列设置为1
            map[j][0] = 1;
            map[j][6] = 1;
        }

        // 设置障碍物
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        Te find = new Te();

        // 打印原地图
        System.out.println("=====原地图======");
        find.printMap(map);
        find.findWay(map, 1,1);
        System.out.println("======找到的路径=====");
        find.printMap(map);
    }
}


class Te {
    public boolean findWay(int[][] map, int i, int j){
        //1. findWay 方法就是专门来找出迷宫的路径
        //2. 如果找到，就返回true ,否则返回false
        //3. map 就是二维数组，即表示迷宫
        //4. i,j 就是老鼠的位置，初始化的位置为(1,1)
        //5. 因为我们是递归的找路，所以我先规定map 数组的各个值的含义
        // 0 表示可以走1 表示障碍物2 表示可以走3 表示走过，但是走不通是死路
        //6. 当map[6][5] =2 就说明找到通路,就可以结束，否则就继续找.
        //7. 先确定老鼠找路策略下->右->上->左
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(findWay(map,i+1, j)){
                    return true;
                } else if(findWay(map,i, j+1)){
                    return true;
                } else if (findWay(map,i-1, j)){
                    return true;
                } else if (findWay(map,i, j-1)){
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void printMap(int[][] map){
        for(int i = 0; i < map.length; i++){  // 打印地图
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
