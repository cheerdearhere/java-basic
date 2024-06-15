package step05_designPatterns.composite.after;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        Item doranBlade = new Item("도란검",450);
        Item healPosion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPosion);
        
        //client side
        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

    //굳이 나눠질 필요가 없음
    private void printPrice(Component component) {
        System.out.println("price: " + component.getPrice());
    }
}
