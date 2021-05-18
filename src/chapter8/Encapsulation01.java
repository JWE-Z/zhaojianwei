package chapter8;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("阿里嘎对");
        person.setAge(80);
        person.setSalary(30000);
        System.out.println(person.info());
        System.out.println(person.getSalary());

        Person smith = new Person("smith", 2000, 50000);
        System.out.println(smith.info());

    }
}
/*
不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
年龄, 必须在1-120, 年龄， 工资不能直接查看， name 的长度在2-6 字符之间
 */

class Person{
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6){
            this.name = name;
        } else {
            System.out.println("名字长度不对");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120){
            this.age = age;
        } else {
            System.out.println("年龄不对，给默认");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info(){
        return "name=" + name + "\tage=" + age + "\tsalary=" + salary;
    }
}

