package chapter9.houserent;

import chapter9.houserent.view.HouseView;

/**
 * 功能： 房屋出租系统入口
 */
public class HouseRentAPP {
    public static void main(String[] args) {
        new HouseView().mainMenu();
        System.out.println("退出系统");

    }
}
