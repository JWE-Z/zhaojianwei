package chapter8.extend_.exercise;

public class NotePad extends Computer{
    public String color;

    public NotePad() {
    }

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo(){
        System.out.println("NotePad信息如下");
        System.out.println(getDetails()+ "\tcolor=" + color);
    }
}
