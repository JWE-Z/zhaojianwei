package chapter8.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        //a 的编译类型A, 运行类型B
        A a = new B();//向上转型
        System.out.println(a.sum());// 30
        System.out.println(a.sum1());//20
    }
}

class A{
    public int i = 10;

    public int sum() {//父类sum()
        return getI() + 10;
    }

    public int sum1() {//父类sum1()
        return i + 10;
    }

    public int getI() {//父类getI
        return i;
    }
}

class B extends A{
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

//    public int sum1() {
//        return i + 10;
//    }

    public int getI() {
        return i;
    }
}