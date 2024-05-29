package step04_middleClass2.chapter02_CollectionFramework.test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
문제3 - 같은 단어가 나타난 수
문제 설명
각각의 단어가 나타난 수를 출력해라.
실행 결과를 참고하자.
package collection.map.test;
import java.util.HashMap;
import java.util.Map;
public class WordFrequencyTest1 {
 public static void main(String[] args) {
 String text = "orange banana apple apple banana apple";
 // 코드 작성
 }
}

실행 결과
{orange=1, banana=2, apple=3}
 */
public class WordFrequencyTest {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        // 코드 작성
        String[] fruits = text.split(" ");
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for(String fruit : fruits){
//            Integer count = wordFrequencies.get(fruit);
//            if(count == null){
//                count = 0;
//            }
//            count++;
//            wordFrequencies.put(fruit, count);
            wordFrequencies.put(fruit,wordFrequencies.getOrDefault(fruit,0) + 1);
        }
        System.out.println(wordFrequencies);
    }
}
