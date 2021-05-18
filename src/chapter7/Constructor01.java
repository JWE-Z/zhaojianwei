package chapter7;

public class Constructor01 {
    public static void main(String[] args){
    Person p1 = new Person("Smith", 20);
    Person p2 = new Person("Tom");
    System.out.println(p1.name + "\t" + p1.age);
    System.out.println(p2.name + "\t" + p2.age);
    Person p3 = new Person();
    System.out.println(p3.name + "\t" + p3.age);
    }
}

class Person{
    String name;
    int age;
    public Person(String pName, int pAge){
        System.out.println("构造器被调用");
        name = pName;
        age = pAge;
    }
    // 构造器重载
    public Person(String pName){
        name = pName;
    }

    Person(){
        age = 18;
    }
}