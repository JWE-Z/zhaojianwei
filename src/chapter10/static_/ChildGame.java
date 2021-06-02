package chapter10.static_;

public class ChildGame {
    public static void main(String[] args) {
        // 类变量 不用创建对象也能使用，在类加载时候就已经存在了
        System.out.println(Child.count);

        Child child1 = new Child("XIAOM");
        child1.join();
        child1.count++;

        Child child2 = new Child("daming");
        child2.join();
        child2.count++;

        System.out.println(Child.count);  //3
        System.out.println(child1.count); //3
        System.out.println(child2.count); //3
    }
}

class Child{
    private String name;
    // 定义一个静态变量count  static count
    // 可以被child类的所有对象实例共享
    // 类变量可以通过类名访问
    // 类变量访问权限也遵守修饰符
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join(){
        System.out.println(name + "加入了游戏");
    }
}
