package step02_basic.chapter09_extends.ex.item;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void print(){
        System.out.println("이름: "+name+", 가격: "+price);
    }
}
