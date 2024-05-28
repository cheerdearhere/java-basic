package step04_middleClass2.chapter02_CollectionFramework.map;

import java.util.*;

public class JavaMap {
    public static void main(String[] args) {
        run(new HashMap<>());
        run(new LinkedHashMap<>());
        run(new TreeMap<>());
    }
    private static void run(Map<String, Integer> map) {
        System.out.println("### class: "+map.getClass().getName());
        long currentTime = System.currentTimeMillis();
        System.out.print("put data ");
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.put("h", 8);
        map.put("i", 9);
        map.put("j", 10);
        currentTime = checkCurrentTime(currentTime);
        System.out.println("iterator ");
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(map.get(iterator.next())+"\t");
        }
        System.out.println();
        currentTime = checkCurrentTime(currentTime);
    }
    private static long checkCurrentTime(long startTimeMillis) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("duration: "+(currentTimeMillis - startTimeMillis));
        return currentTimeMillis;

    }
}
