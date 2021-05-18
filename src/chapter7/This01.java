package chapter7;

public class This01 {
    public static void main(String[] args){
    TeThis t = new TeThis();
    t.f2();

    }
}

class TeThis{

    public TeThis(){
        this("jack", 100);  // 访问构造器语法，必须放在第一条语句
        System.out.println("TeThis()");
    }

    public TeThis(String name, int age){
        System.out.println("TeThis(String name, int age)");
    }

    public void f1(){
        System.out.println("f1");
    }

    public void f2(){
        System.out.println("f2");
        f1();
        this.f1();

    }
}
