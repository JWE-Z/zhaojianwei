package chapter9.houserent.view;

import chapter9.houserent.domain.House;
import chapter9.houserent.service.HouseService;
import chapter9.houserent.utils.Utility;

/**
 * 显示界面
 * 接受用户的输入
 * 调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;
    private final HouseService houseService = new HouseService(10);

    public void listHouses(){
        System.out.println("-----------------------房屋列表---------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t\t地址\t\t月租\t\t状态(出租/未出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("------------------房屋列表显示完毕-------------------");
    }

    public void addHouse(){
        System.out.println("-----------------------添加房屋---------------------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        int phone = Utility.readInt(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        double rent = Utility.readDouble();
        System.out.print("状态：");
        String state = Utility.readString(3);
        if(houseService.addHouse(new House(0, name, phone, address, rent, state))){
            System.out.println("--------------------添加房屋成功---------------------");
        } else {
            System.out.println("--------------------添加房屋失败---------------------");
        }
    }

    public void delHouse(){
        System.out.println("-----------------------删除房屋---------------------");
        System.out.print("请输入需要删除房源ID(-1 退出)：");
        int delID = Utility.readInt();
        if(delID == -1){
            System.out.println("---------------------放弃删除房屋-------------------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(delID)){
                System.out.println("---------------------删除房屋成功-------------------");
            } else {
                System.out.println("----------------- ---房屋ID不存在-------------------");
            }
        } else {
            System.out.println("---------------------放弃删除房屋-------------------");
        }
    }

    public void exit(){
        char confirm = Utility.readConfirmSelection();
        if ('Y' == confirm){
            loop = false;
            System.out.println("\n===================退出房屋出租系统=================");
        }
    }

    public void findHouse(){
        System.out.println("-----------------------查找房屋---------------------");
        System.out.print("请输入需要查找的房源ID：");
        int findID = Utility.readInt();
        House house = houseService.findByID(findID);
        if(house == null){
            System.out.println("----------------------未找到房屋---------------------");
        } else {
            System.out.println("编号\t\t房主\t\t电话\t\t\t地址\t\t月租\t\t状态(出租/未出租)");
            System.out.println(house);
        }
    }

    public void update(){
        System.out.println("-----------------------修改房屋信息---------------------");
        System.out.print("请输入需要修改的房源ID(-1 退出)：");
        int updateID = Utility.readInt();
        if(updateID == -1){
            System.out.println("---------------------放弃修改房屋信息--------------------");
            return;
        }

        House house = houseService.findByID(updateID);
        if(house == null){
            System.out.println("---------------------房屋信息不存在--------------------");
            return;
        }

        System.out.print("姓名(" + house.getName() + ")：");
        String name = Utility.readString(8, "");
        if (!"".equals(name)){
            house.setName(name);
        }
        System.out.print("电话(" + house.getName() + ")：");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)){
            house.setPhone(Integer.parseInt(name));
        }
        System.out.print("地址(" + house.getName() + ")：");
        String address = Utility.readString(16, "");
        if (!"".equals(address)){
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getName() + ")：");
        String rent = Utility.readString(10000, "");
        if (!"".equals(rent)){
            house.setRent(Double.parseDouble(rent));
        }

        System.out.print("状态(" + house.getName() + ")：");
        String state = Utility.readString(3, "");
        if (!"".equals(state)){
            house.setState(state);
        }
        System.out.println("---------------------房屋信息修改成功--------------------");

    }

    public void mainMenu(){
        do{
            System.out.println("\n===================房屋出租系统=================");
            System.out.println("\t\t\t\t1. 新 增 房 源");
            System.out.println("\t\t\t\t2. 查 找 房 源");
            System.out.println("\t\t\t\t3. 删 除 房 源");
            System.out.println("\t\t\t\t4. 修改房源信息");
            System.out.println("\t\t\t\t5. 房 屋 列 表");
            System.out.println("\t\t\t\t6. 退出");
            System.out.println("请选择（1-6）");
            char key = Utility.readCharNum();

            switch(key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入必须在 1 - 6 之间");
            }
        } while (loop);
    }

}
