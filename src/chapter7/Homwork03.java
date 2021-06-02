package chapter7;

public class Homwork03 {
    public static void main(String[] args) {
        Book book = new Book();
        double price = book.updatePrice(20);
        System.out.println(price);
    }
}

class Book{
    public double updatePrice(double price){
        if(price >150){
            return 150;
        } else if( price > 100 ){
            return 100;
        } else {
            return price;
        }
    }
}