
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
# III. HashSet

    
# IV. Set