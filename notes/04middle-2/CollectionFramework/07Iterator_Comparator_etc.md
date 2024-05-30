
# I. 순회
- 다양한 자료구조가 있고 자료에 접근하는 방법이 다르다. 
  - ArrayList, LinkedList, HashMap, TreeMap, LinkedHashMap...
## A. Iterable, Iterator
- `Iterable`, `Iterator`: 자료구조가 갖는 자료 전체에 접근할때 내부 구조를 몰라도, 다알지 못해도 알 수 있도록 도와주는 기능을 담당
  - Iterable: 반복자를 수행할 클래스에서 구현할 인터페이스
  ```java
    public interface Iterable<T>{
      Iterator<T> iterator();
    }
  ```
  - Iterator: 반복에 필요한 기능을 갖는 인터페이스.
  ```java
    public interface Iterator<E>{
        boolean hasNext();// 순회 중 다음 포인터에 대상이 있는지 확인
        E next();// 다음의 값을 반환. 
    }
  ```
![iterator](../../img/middle/CollectionFrameworks/Iterator.png)
- [직접 만들기](../../../src/step04_middleC lass2/chapter02_CollectionFramework/utils/iterator/MyArrayIterator.java)
  - Iterable 사용
    ```java
    public class MyArray implements Iterable<Integer>{
        private int[] numbers;
        public MyArray(int[] numbers) {
            this.numbers = numbers;
        }
        
        @Override
        public Iterator<Integer> iterator() {
            return new MyArrayIterator(numbers);
        }
    }
    ```
  - Iterator 사용
    ```java
    public class MyArrayIterator implements Iterator<Integer> {
        private int currentIndex = -1;
        private int[] targetArr;
    
        public MyArrayIterator(int[] targetArr) {
            this.targetArr = targetArr;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < targetArr.length -1;// index 기준 마지막 항목
        }
    
        @Override
        public Integer next() {
            return targetArr[++currentIndex];//증가 시키고 해당 항목 전달
            //hasNext()로 체크하지 않으면 예외
        }
    }
    ```
  - main
    ```java
        public static void main(String[] args) {
            MyArray myArray = new MyArray(new int[]{3,4,5,6});
            Iterator<Integer> iterator = myArray.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    ```
## B. enhanced For Loop
- `Iterable`을 사용하면 향상된 for 문을 사용할 수 있다.  
- `forEach`도 사용 가능해진다
```java
        for(Integer i : myArray) {
            System.out.print(i+"\t");
        }
        myArray.forEach(System.out::print);
```
## C. 자바의 Iterable
- `Collection`의 부모가 `Iterable` 
  - `Map`은 key - value 구조이므로 별도의 메서드로 Collection 객체로 만들어 순회시킬 수 있다. 
    - `keySet()`, `values()`, `entrySet()`
  - Collection의 내부 구조는 보이지 않지만 사용자가 사용할 수 있고, 코드 재사용성도 
![자바 구조](../../img/middle/CollectionFrameworks/Java_IterableInterface.png)

```java
import java.util.*;

public static void main(String[] args) {
  useEnhancedForLoop(new LinkedList<Integer>());
  useEnhancedForLoop(new HashSet<Integer>());
  useEnhancedForLoop(new ArrayDeque<Integer>());
//  ....
}

private static void useEnhancedForLoop(Iterator<Integer> iterator) {
  //generic이 일치하는 모든 컬렉션에서 사용 가능
  for (Integer i : iterator)
    System.out.println(i);
}
```
# II. 정렬
## A. [가장 단순한 정렬](../../../src/step04_middleClass2/chapter02_CollectionFramework/utils/comparator/ArraySortMain.java)
```java
for(int i=0;i<arr.length-1;i++){
    for(int j=0 ; j<arr.length - 1 - i ; j++){
        if(arr[j]>arr[j+1]){// 비교
            int temp = arr[j];
            arr[j] = arr[j+1];//변경
            arr[j+1] = temp;
        }
    }
}
```
- 반복을 통한 정렬은 효율이 좋지 않음
  - 자바 초기: 퀵 소트
  - 현재: 평균 `O(n log n)`
    - 데이터가 작을때(32개 이하): Dual-Pivot QuickSort
    - 데이터가 많을때: TimSort
## B. 정렬의 시작은 비교자
  - Comparable: 직접 만든 객체에 기본 비교 로직을 지원
  - Comparator: sort()에 인수로 들어가는 비교연산 객체
### 1. [Comparator](../../../src/step04_middleClass2/chapter02_CollectionFramework/utils/comparator/SortMain1.java)
```java
public interface Comparator<T>{
  /**
   * @return int 
   * 첫 인수가 작으면 음수 반환(-1)
   * 두 값이 같으면 0
   * 첫 인수가 크면 양수 반환(1)
   */
    int compare(T o1, T o2);// 비교 메서드 구현
}
```
- 오름차순
```java
static class AscComparator implements Comparator<Integer> {
@Override
public int compare(Integer o1, Integer o2) {
    System.out.println("o1: " + o1 + " / o2: " + o2);
    return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
    }
}
```
- 내림차순
```java
static class DescComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return ((o1<o2)?-1:(o1==o2) ?0 :1) * -1;
    }
}
```
- 비교 처리하는 곳에서 인자로 전달
```java
    Arrays.sort(arr,new AscComparator());
```
- 역방향 정렬을 지원해줌
  - ASC.reversed() -> DESC
```java
    Arrays.sort(arr,new AscComparator().reversed()); // == DescComparator
```
### 2. [Comparable](../../../src/step04_middleClass2/chapter02_CollectionFramework/utils/comparator/SortMain2.java)
- 직접 만든 객체가 기본적으로 비교 방식을 처리하도록 돕는 인터페이스
  - 별도의 비교자(Comparator)를 처리하지 않는 이상 기본 적용
```java
public class MyUser implements Comparable<MyUser> {
    private String id;
    private int age;

    //...

    @Override
    public int compareTo(MyUser o) {
        return age-o.age;
    }
}
```
- Comparable이나 Comparator 둘 중 하나도 없이 sort()를 호출하면 문제가 발생한다. 
  - ClassCastException
## C. 자료구조에 적용하기
- 당연한 말이지만 Set과 같이 순서가 없는 자료구조에는 쓸 수 없다
### 1. [List](../../../src/step04_middleClass2/chapter02_CollectionFramework/utils/comparator/ListSort.java)
- 객체에 있는 메서드(권장)
```java
    list.sort(null);//기본 정렬(Comparable)
    list.sort(new IdComparator());//비교자 사용
```
- Collections 사용
```java
    Collections.sort(list);//Collections 가능
    Collections.sort(list, new IdComparator());
```
### 2. [Tree](../../../src/step04_middleClass2/chapter02_CollectionFramework/utils/comparator/TreeSort.java)
- tree 구조는 데이터를 넣을때부터 비교가 진행되므로 비교자(Comparable, Comparator)가 필수
```java
    //MyUser 기본 비교자
    TreeSet<MyUser> users = new TreeSet<MyUser>();
    users.add(m1);
    users.add(m2);
    users.add(m3);

    //외부 비교자
    TreeSet<MyUser> users2 = new TreeSet<MyUser>(new IdComparator());
    users2.add(m1);
    users2.add(m2);
    users2.add(m3);
```
- 자바의 정렬 알고리즘이 이미 잘 되어있으므로 직접 구현하기보다 있는걸 잘쓰는걸로
# III. Collection utilities
# IV. Collection Framework 정리
# V. 실습문제