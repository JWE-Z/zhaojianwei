package chapter7;

public class Homwork08 {
    public static void main(String[] args) {

    }
}


class Employee{
    String name;
    char gender;
    int age;
    String job;
    double salary;

    public Employee(String job, double salary){
        this.job = job;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name, char gender, int age, String job, double salary){
        this(name, gender, age);
        this.job = job;
        this.salary = salary;
    }
}

