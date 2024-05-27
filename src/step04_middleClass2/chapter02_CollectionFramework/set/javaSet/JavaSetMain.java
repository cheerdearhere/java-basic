package step04_middleClass2.chapter02_CollectionFramework.set.javaSet;

import java.util.*;

public class JavaSetMain {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        run(hashSet);
        run(linkedHashSet);
        run(treeSet);
    }
    private static void run(Set<String> strSet) {
        System.out.println("class: "+strSet.getClass());
        long startTime = System.currentTimeMillis();
        strSet.add("C");
        strSet.add("B");
        strSet.add("A");
        strSet.add("1");
        strSet.add("a");
        strSet.add("2");
//        System.out.println("set: "+strSet);
        Iterator<String> iterator = strSet.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next()+"  \n");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }
}
