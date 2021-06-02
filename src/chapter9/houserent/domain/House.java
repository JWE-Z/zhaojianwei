package chapter9.houserent.domain;

/**
 * 表示一个房屋信息
 */
public class House {
    // 编号，房主 电话  地址 月租 状态(出租/未出租)
    private int id;
    private String name;
    private int phone;
    private String address;
    private double rent;
    private String state;

    public House(int id, String name, int phone, String address, double rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t" + phone +
                "\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
