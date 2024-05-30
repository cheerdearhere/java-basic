package step04_middleClass2.chapter02_CollectionFramework.utils.iterator;

import java.util.Iterator;

public class MyArrayMain {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(new int[]{3,4,5,6});
        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
        for(Integer i : myArray) {
            System.out.print(i+"\t");
        }
        myArray.forEach(System.out::print);
    }
}
