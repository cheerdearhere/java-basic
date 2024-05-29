package step04_middleClass2.chapter02_CollectionFramework.test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
문제2 - 공통의 합
문제 설명
map1 과 map2 에 공통으로 들어있는 키를 찾고, 그 값의 합을 구해라.
실행 결과를 참고하자.
package collection.map.test;
import java.util.HashMap;
import java.util.Map;
public class CommonKeyValueSum1 {
 public static void main(String[] args) {
 Map<String, Integer> map1 = new HashMap<>();
 map1.put("A", 1);
 map1.put("B", 2);
 map1.put("C", 3);
 Map<String, Integer> map2 = new HashMap<>();
 map2.put("B", 4);
 map2.put("C", 5);
 map2.put("D", 6);
 // 코드 작성
 }
}

실행 결과
{B=6, C=8}
 */
public class SameKeySum {
    public static void main(String[] args) {
//        Map<String, Integer> map1 = new HashMap<>();
//        map1.put("A", 1);
//        map1.put("B", 2);
//        map1.put("C", 3);
        Map<String,Integer> map1 = Map.of(
                "A", 1,
                "B", 2,
                "C", 3
        );
//        Map<String, Integer> map2 = new HashMap<>();
//        map2.put("B", 4);
//        map2.put("C", 5);
//        map2.put("D", 6);
        Map<String,Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);
        // 코드 작성
        Map<String, Integer> resultMap = new HashMap<>();
        //내가 만든것
//        Set<String> map2Keys = map2.keySet();
//        for(Map.Entry<String, Integer> entry : map1.entrySet()){
//            if(map2Keys.contains(entry.getKey())){
//                resultMap.put(entry.getKey(), entry.getValue()+map2.get(entry.getKey()));
//            }
//        }
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                resultMap.put(key, map1.get(key) + map2.get(key));
            }
        }
        System.out.println(resultMap);
    }
}
