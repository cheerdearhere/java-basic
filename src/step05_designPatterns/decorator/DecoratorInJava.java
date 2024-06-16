package step05_designPatterns.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecoratorInJava {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");

        List books = Collections.checkedList(list, Book.class);

        list.add(new Item());
        books.add(new Item());
    }

    private static class Book{}
    private static class Item{}
}
