package chapter8.extend_.exercise;

public class Pc extends Computer{
    private String brand;

    public Pc() {
    }

    public Pc(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo(){
        System.out.println("pc信息如下");
        System.out.println(getDetails() + "\tbrand=" + brand);
    }
}
