package chapter7;

import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        PersonTe p1 = new PersonTe("Smith", 20);
        PersonTe p2 = new PersonTe("maru", 30);
        System.out.println(p1.compareTo(p2));
        Scanner scanner = new Scanner(System.in);
    }

}


class PersonTe{
    String name;
    int age;
    public PersonTe(String name, int age){
        System.out.println("构造器被调用");
        this.name = name;
        this.age = age;
    }



    public boolean compareTo(PersonTe p){
//        if(this.name.equals(p.name) && this.age == p.age){
//            return true;
//        } else {
//            return false;
//        }
        return this.name.equals(p.name) && this.age == p.age;
    }
}