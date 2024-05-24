
# I. 시작
- List vs Set

| List  | 비교    | Set |
|-------|-------|-----|
| O     | 순서    | X   |
| O     | 중복 허용 | X   |
| index | 접근    | 순회  |
| 순열    | 이해    | 집합  |

- [기본적인 Set 구현하기](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetV0.java)
  - 순서(index)가 없기때문에 더 단순
  - 물론 정말 기초임을 기억
  - 기본 기능
    - `boolean add(value)`: 추가
    - `boolean contains(value)`: 조회
    - `int getSize()`: 자료 수
    - `boolean remove(value)`: 삭제
- 반복문을 돌릴경우 `O(n)`으로 검색 효율이 좋진 않다
- 데이터를 추가할때마다 중복데이터를 확인하기위한 검색을 진행하므로 성능의 발목을 잡는다. 
- 이를 해결하기 위한 것이 Hash 알고리즘이다
# II. Hash Algorithm
## A. 이해를 위한 예제: 배열을 사용해 구현하기
- 기능
  - 입력: 0~9 사이의 임의의 값 입력, 중복은 입력되지 않음
  - 찾기: 0~9 사이의 하나 입력되면 해당 값이 있는지 확인
- 배열을 사용한 경우: [HashStart0](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/hashAlgorithm/HashStart0.java)
  - 검색: `O(n)`
    ```java
        for(int intValue: intArr){
            if(intValue == searchValue){
                System.out.println(intValue);
            }
        }
    ```
  - 조회: `O(1)`
    - 인덱스를 사용하는 경우는 매우 효율적.
## B. 검색에 배열을 사용할 수 없을까?
- index와 값을 일치시키면 되지 않을까?????
```java
Integer[] intArr2 = new Integer[10];
intArr2[1] = 1;
intArr2[2] = 2;
intArr2[5] = 5;
intArr2[8] = 8;
System.out.println("inputArr: "+ Arrays.toString(intArr2));
int searchValue2 = 8;
System.out.println("search: "+intArr2[searchValue2]);
```
- 순서는 무시되지만 검색 효율이 매우 높아짐: `O(1)`
- 문제: 입력 가능한 값의 범위(0~9)만큼 메모리가 요구되므로 메모리 낭비가 심해진다
## C. [메모리 낭비](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/hashAlgorithm/HashStart1.java)
- 기능: 범위를 더 늘린다
    - 입력: 0~99 사이의 임의의 값 입력, 중복은 입력되지 않음
    - 찾기: 0~99 사이의 하나 입력되면 해당 값이 있는지 확인
```
[
    null, 1, 2, null, null, 5, null, 7, null, null, null, 
    null, 12, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, 56, null, null, null, 
    null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, 77, null, null, 
    null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, null, 99
]
```
- 속도는 빠르나...메모리 낭비가...
  - 만약 입력 기대값이 int 범위(-2,147,483,648~2,147,483,647)이라면... 
  - 4byte * 42억 = 17GB
## D. [Hash Index](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/hashAlgorithm/HashStart2.java)
- CAPACITY가 10인 배열을 사용한다면
- 나머지 연산 : 대상 % 배열크기 = 배열크기 내 나머지 -> index
```
    1 % 10 = 1
    2 % 10 = 2
    ...
    9 % 10 = 9
    10 % 10 = 0
```
- 이를 통해
  - 14 -> index 4에 저장
  - 99 -> index 9에 저장
- 이처럼 배열의 인덱스로 사용할 수 있도록 원래의 값을 계산한 인덱스를 해시 인덱스(hashIndex)라 한다
  - 빠른 성능(`O(1)`)을 제공
  - 추가할때 조회할 때 매번 연산
  - 메모리 낭비를 많이 줄임
- 문제
  - 19와 99가 동시에 들어온다면..?
    - 19 -> index 9
    - 79 -> index 9
    - 99 -> index 9
  - 뒤에 입력되는 값에 덮어씌워짐 => 해시 충돌
## E. [해시 충돌](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/hashAlgorithm/HashStart3.java)
- 다른 값을 입력했지만 같은 hash index가 나와 충돌이 발생(데이터가 충돌)
  - 조건 처리에 따라 덮어씌울지 추가를 거절시킬지 달라짐
  - 해결방법? CAPACITY 확장 -> 데이터 낭비 원점
    - 해시 충돌 발생의 확률을 인정하면...
      - 같은 해시의 값을 같은 인덱스에 저장(이중 배열)
- [LinkedList[] 사용](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/hashAlgorithm/HashStart4.java): HashStart3와 같으나 LinkedList[]사용
  - 더 편리함
  - ArrayList도 가능
- 입력하는 데이터의 수가 CAPACITY 크기의 75%를 넘으면 해시 인덱스는 자주 충돌을 만들지 않는다.
- 그러나 이를 위해 배열의 크기를 늘리면 메모리 낭비가 심해진다.
- Hash Index 효율: 배열의 크기가 적절하다면 크게 문자가 생기지 않는다
  - 입력
    - 평균: O(1)
    - 최악: O(n) - 충돌
  - 조회
    - 평균: O(1)
    - 최악: O(n) - 충돌
# III. HashSet 구현해보기
- 핵심 특성
  - 중복 x 
  - 순서 x 
  - 빠른 검색기능
- [Main class](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetMain.java): 같은 기능을 다른 로직으로 진행하므로 클라이언트 코드에 영향을 주지 않음
```java
//        MyHashSetV0 set = new MyHashSetV0();
        MyHashSetV1 set = new MyHashSetV1();
        MyHashSetV2 set = new MyHashSetV2();
        MyHashSetV3 set = new MyHashSetV3();
```
## A.[MyHashSetV1](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetV1.java): 해시 알고리즘(hash index)
```java
public class MyHashSetV1 {
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Integer>[] buckets;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public MyHashSetV1();
    public MyHashSetV1(int initialCapacity);
    
    public boolean add(int value);
    public boolean contains(int searchValue);
    public boolean remove(int value);
    public int getSize();
    
    private void initBucket();
    private int getHashIndex(int value);
    
    @Override
    public String toString();
```
- 특징
  - 최악의 경우를 제외하고 검색시 O(1)을 보장
    - 등록, 검색, 삭제 모두 평균 O(1) 
  - 충돌가능성 낮춤
- 문제: 데이터의 값이 index인 양의 정수가 아니라면..?
- 주의: List의 remove()의 매개변수 타입에 따라 호출되는 메서드가 다름 
  - 기본형인 int가 전달되면 index 기준으로 삭제함
## B. MyHashSetV2: 해시 코드
### 1. [문자 해시코드](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/objectHash/StringHashMain.java)
- 모든 문자는 각자 고유한 코드를 지닌다: ASCII, UTF-8 ...
```java
public static void main(String[] args) {
    //char
    char charA = 'A';
    char charB = 'B';
    
  System.out.println("charA = " + charA);
  System.out.println("charA code = " + (int) charA);
  System.out.println("charB code = " + (int) charB);
  //charA = A
  //charA code = 65
  //charB code = 66
}
```
- 문자열을 코드화 시키는 가장 단순한 방법 -> 문자 코드를 더해서 사용
```java
private static int hash(char ch) {
  return (int) ch;
}
private static int hash(String str) {
    int hash = 0;
    char[] chars = str.toCharArray();
    for(char ch : chars) {
        hash += (int) ch;
    }
    return hash;
}
private static int hashIndex(char value){
  int hash = hash(value);
  return hash % CAPACITY;
}
private static int hashIndex(String str){
  int hash = hashCode(str);
  return hash % CAPACITY;
}
```
- 이렇게 배열의 인덱스를 사용해 값을 저장, 조회
  - 알고리즘에 따라 암호화를 위해 사용될 수 있음
![String's hashCode](../../img/middle/CollectionFrameworks/HashCode_String.png)
- 충돌 가능: 다른 데이터임에도 값 자체가 같을 수 있다.
  - "AD" -> A(65) + D(68) => 133
  - "BC" -> B(66) + C(67) => 133
- 해시코드화 시키고나면 해시 인덱스를 통해 사용할 수 있다. 
  - 사용자가 직접 만든 Custom type은 어떻게???
### 2. [java의 hashCode](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/objectHash/JavaHashCodeMain.java): Object 클래스의 method
- 모든 객체에 적용할 수있는 방법: Object class 이용
  - default: 인스턴스의 참조값(메모리주소)
  - 그대로 사용하지않고 재정의해서 사용
```java
public class Object{
//  ...
    public int hashCode();
}
```
- Java 소속 클래스들은 이미 재정의 되어있음
  - 음의 정수도 있음
```
10.hashCode() = 10
strA.hashCode() = 65
strAB.hashCode() = 2081
Integer.valueOf(-1).hashCode() = -1
```
- 사용자가 직접 만든 클래스에서 값은 같지만 다른 인스턴스인 경우
- 사용하는 데이터를 기반으로 비교하도록 재정의
  - `Objects.hashCode(hash 변환에 사용할 값);`
```java
@Override
public int hashCode() {
    return Objects.hashCode(id);
}
```
- 동일성과 동등성
```java
public static void main(String[] args) {
  System.out.println("member1 == dupMember1 = " + (member1==dupMember1));
  System.out.println("identity String(member1) = " + Objects.toIdentityString(member1));
  System.out.println("identity String(dupMember1) = " + Objects.toIdentityString(dupMember1));
  System.out.println("member1.equals(dupMember1) = " + member1.equals(dupMember1));
  System.out.println("member1.hashCode() = " + member1.hashCode());
  System.out.println("dupMember1.hashCode() = " + dupMember1.hashCode());
}

// member1 == dupMember1 = false 동일성
// identity String(member1)    = ....Member@7530d0a
// identity String(dupMember1) = ....Member@27bc2616
// member1.equals(dupMember1) = true 동등성
// member1.hashCode() = 104070
// dupMember1.hashCode() = 104070
```
- 값을 비교해야하므로 equals()도 재정의해야한다
  - `instanceof` 사용
  ```java
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Member member)) return false;
      return Objects.equals(id, member.id);
  }
  ```
  - `getClass()` 사용
  ```java
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return Objects.equals(id, member.id);
  }
  ```
### 3. [MyHashSetV2](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetV2.java): Hash code 사용
- 이를 사용해 구현해보자
- hash index는 0~양수이므로 절대값 처리(`Math.abs()`)
```java
private int getHashIndex(Object value){
    int hashCode = Math.abs(value.hashCode());
    int hashIndex = hashCode % capacity;
    return hashIndex;
//    return Math.abs(value.hashCode()) % capacity;
}
```
## C.[직접만든 클래스 저장하기](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetMainCustom.java)
- 주의!! 
  - 커스텀 클래스에 `equals()`와 `hashCode()`가 재정의되어있지 않으면 문제가 생긴다
  - java의 객체들은 기본적으로 재정의되어있으나 개발자가 직접 만든 클래스는 없음을 주의하자
- `Member`에 equals()가 재정의되어있지않으면 내부에서 이를 사용하는 contain()이 제대로 작동하지 않음
## D. equals(), hashCode() 재정의의 중요성
## E. [MyHashSetV3](../../../src/step04_middleClass2/chapter02_CollectionFramework/set/MyHashSetV3.java): Generic, Interface 적용
# IV. Set