package step04_middleClass2.chapter02_CollectionFramework.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapBasic {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new TreeMap<>();

        // 성적 데이터 추가
        studentMap.put("John", 90);
        studentMap.put("Jane", 80);
        studentMap.put("Bob", 80);
        studentMap.put("Jack", 80);
        studentMap.put("Jill", 100);
        System.out.println(studentMap);

        //특정 학생의 값 조회
        Integer bobScore = studentMap.get("Bob");
        System.out.println(bobScore);

        //Key Set
        Set<String> keySet = studentMap.keySet();
        for (String key : keySet) {
            System.out.print("key: "+key+"\t");
        }

        //Values -> Collection
        Collection<Integer> values = studentMap.values();
        for(Integer value : values) {
            System.out.print("value: "+value+"\t");
        }

        //Entries
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        entries.forEach(System.out::println);

        //중복된 Key
        System.out.println("before: "+studentMap.get("John"));
        studentMap.put("John", 10);
        System.out.println("after: "+studentMap.get("John"));

        //contains check
        boolean isContained = studentMap.containsKey("John");
        System.out.println("isContained: "+isContained);

        //remove
        studentMap.remove("John");
        System.out.println("remove after: "+studentMap.get("John"));
        System.out.println(studentMap);
    }
}
