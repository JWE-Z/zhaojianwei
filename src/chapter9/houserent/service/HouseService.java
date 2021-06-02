package chapter9.houserent.service;

import chapter9.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "jack", 11225345, "大明宫", 1300, "未出租");
    }

    public boolean addHouse(House newHouse){
        if (houseNums >= houses.length){
            System.out.println("数组已经满了，无法添加");
            return false;
        }
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null){
                houses[i] = newHouse;
                houseNums++;
                newHouse.setId(++idCounter);
                return true;
            }
        }
        return false;
    }

    public boolean del(int delID){
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
//            if(houses[i] != null && houses[i].getId() == delID){
            if(houses[i].getId() == delID){
                index = i;
                break;
            }
        }

        if (index == -1){
            return false;
        }
//           houses[index] = null;
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }

        houses[--houseNums] = null;
        return true;
    }

    public House findByID(int findID){
        for (int i = 0; i < houseNums; i++) {
            if(houses[i].getId() == findID){
                return houses[i];
            }
        }
        return null;
    }

    public House[] list(){
        return houses;
    }
}
