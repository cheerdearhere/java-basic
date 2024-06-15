package step05_designPatterns.composite.before;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> items;
    public Bag() {
        items = new ArrayList<>();
    }
    public void add(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
}
