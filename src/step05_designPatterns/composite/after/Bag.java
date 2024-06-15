package step05_designPatterns.composite.after;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {

    private final List<Component> components = new ArrayList<>();

    public void add(Component item) {
        components.add(item);
    }
    public List<Component> getItems() {
        return components;
    }

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}
