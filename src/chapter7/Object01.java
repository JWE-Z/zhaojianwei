package chapter7;

public class Object01 {
    public static void main(String[] args){
        Cat cat = new Cat();
        cat.name = "aka";
        cat.age = 13;
        cat.color = "中花灰";

        MyTools myTools = new MyTools();
        Cat c2 = myTools.copyCat(cat);

        System.out.println("cat 的属性age=" + cat.age + " 名字=" + cat.name + "  颜色" + cat.color);
        System.out.println("c2 的属性age=" + c2.age + " 名字=" + c2.name + "  颜色" + c2.color);
        System.out.println(cat == c2);
    }
}

class Cat{
    String name;
    int age;
    String color;
}
class MyTools{
    // 拷贝对象
    public Cat copyCat(Cat c){
        Cat c2 = new Cat();
        c2.name = c.name;
        c2.age = c.age;
        c2.color = c.color;
        return c2;
    }
}

