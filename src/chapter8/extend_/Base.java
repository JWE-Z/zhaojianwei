package chapter8.extend_;

public class Base{
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base(String name, int age){
        System.out.println(" Base(String name, int age)");
    }

    public Base(String name){
        System.out.println(" Base(String name)");
    }

    public Base() {
        System.out.println("base()...");
    }

    public void test100(){
        System.out.println("test100");
    }

    protected void test200(){
        System.out.println("test200");
    }

    void test300(){
        System.out.println("test300");
    }

    private void test400(){
        System.out.println("test400");
    }

    public int getN4(){
        return n4;
    }
    public void callTest400(){
        test400();
    }
}
