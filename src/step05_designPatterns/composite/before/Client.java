package step05_designPatterns.composite.before;

import java.util.Iterator;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        Item doranBlade = new Item("도란검",450);
        Item healPosion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPosion);
        
        //client 입장에서 원하는 정보가 따로 있는 경우 직접 메서드를 생성
        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
        client.printTotalPrice(bag);
        System.out.println(client.printAverage(bag));
    }

    private double printAverage(Bag bag) {
        return bag.getItems().stream()
                .mapToInt(Item::getPrice)
                .average()
                .orElse(0);
    }

    private void printTotalPrice(Bag bag) {
        Iterator<Item> it = bag.getItems().iterator();
        int totalPrice = 0;
        while (it.hasNext()) {
            totalPrice += it.next().getPrice();
        }
        System.out.println("Total price: " + totalPrice);
    }

    private void printPrice(Bag bag) {
        bag.getItems().forEach(item -> System.out.println("\t"+item.getName()+": "+item.getPrice()));
    }

    private void printPrice(Item item) {
        System.out.println(item.getName()+": "+item.getPrice());
    }
}
