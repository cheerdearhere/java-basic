package step04_middleClass2.chapter02_CollectionFramework.test.list;

public class Item {
    private String name;
    private int price;
    private int quantity;
    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getTotalPrice() {
        return price * quantity;
    }
}
