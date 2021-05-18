package chapter8.extend_;

public class Sub extends Base{
    public Sub(){
//        super();
        System.out.println("Sub()....");
    }

    public Sub(String name, int age){
        super(name, age);
        System.out.println("Sub(String name, int age)");
    }


    public void sayOk(){
        /*
        子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问,
        但是私有属性和方法不能在子类直接访问，
        要通过父类提供公共的方法去访问
         */
        System.out.println("n1: " + n1 + "\tn2=" +  n2 + "\tn3=" +  n3
//                + "\tn4=" +  n4
                + "\tn4=" +  getN4()
        );
        test100();
        test200();
        test300();
//        test400;
        callTest400();
    }



}
