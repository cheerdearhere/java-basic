
# I. Map
## A. 구조 설명
- Key-Value 쌍으로 이뤄진 데이터 구조
  - Key: 중복 불가로 유일값으로 사용. 순서를 유지하지 않음
  - Value: 중복 허용

| Key | Value |
|-----|-------|
| 학생1 | 90    |
| 학생2 | 100   |
| 학생3 | 85    |
| 학생4 | 90    |

## B. Java Map
![map 구조](../../img/middle/CollectionFrameworks/Map.png)
- [java 8 document page - map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
- Collection interface와 상관 없으나 함께 자주 사용됨
- Hash Map 

## C. [유용한 method](../../../src/step04_middleClass2/chapter02_CollectionFramework/map/MapBasic.java)
- 생성: generic으로 Key, Value 타입 지정
```java
  Map<String, Integer> studentMap = new TreeMap<>();
```
- 데이터 추가: key는 중복 x. value는 큰상관 x
  - 같은 key를 사용하는 경우 덮어씌워짐
```java
    studentMap.put("Bob", 80);
    studentMap.put("Jack", 80);
    studentMap.put("Jill", 100);
    studentMap.put("Jill", 10);//덮어씌워짐
    
```
- 데이터 조회: key를 사용해서 값 사용 가능
```java
    Integer bobScore = studentMap.get("Bob");
```
- KeySet: 중복x, 순서x인 Key의 집합(Set)
```java
    Set<String> keySet = studentMap.keySet();
```
- values collection: 중복 허용 but 순서 x > list는 아닌 Collection
```java
    Collection<Integer> values = studentMap.values();
```
- entries: map을 각각 사용
```java
    Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
```
- contains: key로 등록된 자료가 있는지 확인
```java
    boolean isContained = studentMap.containsKey("John");
```
- remove: 특정 값 제거
```java
    studentMap.remove("John");    
```
- [Map 이용해보기](../../../src/step04_middleClass2/chapter02_CollectionFramework/map/StudentMapMain.java)
## D. Map vs Set
- 순서가 없고 중복이 없는 Key의 특성은 Set과 같음
  - 다만 key는 Value와 1:1로 연결되어있다는 점이 다름
  - 실제로 HashSet은 HashMap을 이용해 구현되어있음
```java
public class HashSet<E>
    implements Set<E> //...
{
  transient HashMap<E, Object> map;//내부에서 작동하는 map
  public boolean contains(Object o) {
    return map.containsKey(o);// 사용중
  }
  public boolean add(E e) {
    return map.put(e, PRESENT)==null;// 생성시 value는 null
  }
  public boolean remove(Object o) {
    return map.remove(o)==PRESENT;// 사용중
  }
}
```
- 순서가 없고 중복은 허용하는 Value는 List와 다름. Collection 객체
- Set의 종류와 같음. 옆에 value가 있는 차이
  - HashMap: 일반적으로 사용
  - LinkedHashMap: 입력 순서를 노드로 유지
  - TreeMap: 정렬이 필요한 경우 사용
- Map 작동 원리
  - Key 해시코드 생성 -> 해시 인덱스 -> 저장
  - 저장될때 엔트리(key|value)가 함께 저장 
  - 이처럼 키와 벨류로 저장되는 방식을 hashTable
- Key는 Hash algorithm을 사용하므로 반드시 `hashCode`와 `equals`를 구현해야한다
  - value는 별도의 자료구조를 사용하지 않으므로 탐색에서 사용하지 않는 것을 권장
- 이와같은 구조를 `dictionary`라고 부르기도함
# II. Stack
# III. Queue
# IV. Deque
# V. 실습 문제