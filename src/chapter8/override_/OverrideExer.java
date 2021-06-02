package chapter8.override_;

public class OverrideExer {
    public static void main(String[] args) {
        Person jack = new Person("jack", 10);
        System.out.println(jack.say());
        Student tom = new Student("tom", 20, 124, 99);
        System.out.println(tom.say());
    }
}

