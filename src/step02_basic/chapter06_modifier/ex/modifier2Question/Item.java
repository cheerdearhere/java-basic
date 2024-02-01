package step02_basic.chapter06_modifier.ex.modifier2Question;

public class Item {
    private String name;
    private int price;
    private int quantity;
    public Item(String name, int price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getItemName(){
        return name;
    }
    public int getCost(){
        return price*quantity;
    }
}
