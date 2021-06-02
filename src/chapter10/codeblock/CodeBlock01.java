package chapter10.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie tangtan = new Movie("tangtan", 100);
//        电影屏幕打开
//        广告开始
//        电影开始
//        CodeBlock01(String name, double price)
    }

}


class Movie{
    private String  name;
    private double price;
    private String director;

    // 下面代码块每个构造器都会调用
    // 代码块运行优先于构造器
    {
        System.out.println("电影屏幕打开");
        System.out.println("广告开始");
        System.out.println("电影开始");
    }

    public Movie(String name, double price) {
        System.out.println("CodeBlock01(String name, double price)");
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", director='" + director + '\'' +
                '}';
    }

    public Movie(String name, double price, String director) {
        System.out.println("CodeBlock01(String name, double price, String director)");
        this.name = name;
        this.price = price;
        this.director = director;


    }
}


