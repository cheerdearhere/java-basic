package step04_middleClass2.chapter02_CollectionFramework.test.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
문제4 - 값으로 검색
문제 설명
다음 예제에서 Map 에 들어있는 데이터 중에 값이 1000원인 모든 상품을 출력해라.
실행 결과를 참고하자.
package collection.map.test;
import java.util.*;
public class ItemPriceTest {
 public static void main(String[] args) {
 Map<String, Integer> map = new HashMap<>();
 map.put("사과", 500);
 map.put("바나나", 500);
 map.put("망고", 1000);
 map.put("딸기", 1000);
 // 코드 작성
 }
}
실행 결과
[망고, 딸기]
 */
public class ItemPriceTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);
        // 코드 작성
        Integer searchPrice = 1_000;
        List<String> resultProduct = new ArrayList<>();
        for(Map.Entry<String, Integer> fruit: map.entrySet()) {
            if(searchPrice.equals(fruit.getValue())) {
                resultProduct.add(fruit.getKey());
            }
        }
        System.out.println(resultProduct);
    }
}
