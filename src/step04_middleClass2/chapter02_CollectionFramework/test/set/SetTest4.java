package step04_middleClass2.chapter02_CollectionFramework.test.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
문제4 - 합집합, 교집합, 차집합
문제 설명
두 숫자의 집합이 제공된다.
집합1: 1, 2, 3, 4, 5
집합2: 3, 4, 5, 6, 7
두 집합의 합집합, 교집합, 차집합을 구해라. 출력 순서는 관계없다.
합집합: 두 집합의 합이다. 참고로 중복은 제거한다. [1, 2, 3, 4, 5, 6, 7]
교집합: 두 집합의 공통 값이다. 참고로 중복은 제거한다. [3, 4, 5]
차집합: 집합1에서 집합2와 같은 값을 뺀 나머지 [1, 2]
다음 실행 결과를 참고하자.
Set 인터페이스의 주요 메서드를 참고하자.
SetOperationsTest - 코드 작성
package collection.set.test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class SetOperationsTest {
 public static void main(String[] args) {
 Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
 Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
 //코드 작성
 }
}

합집합: [1, 2, 3, 4, 5, 6, 7]
교집합: [3, 4, 5]
차집합: [1, 2]
 */
public class SetTest4 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
        //코드 작성
        Set<Integer> unionSet = new TreeSet<>();
        unionSet.addAll(set1);
        unionSet.addAll(set2);
        System.out.println("합집합: "+unionSet);

        Set<Integer> intersectionSet = new TreeSet<>();
//        for(Integer i : set1){
//            if(set2.contains(i)){
//                intersectionSet.add(i);
//            }
//        }
        intersectionSet.addAll(set1);
        intersectionSet.retainAll(set2);
        System.out.println("교집합: "+intersectionSet);

        Set<Integer> differenceSet = new TreeSet<>();
//        for(Integer i : set1){
//            if(set2.contains(i)){
//                continue;
//            }
//            differenceSet.add(i);
//        }
        differenceSet.addAll(set1);
        differenceSet.removeAll(set2);
        System.out.println("차집합: "+differenceSet);
    }
}
