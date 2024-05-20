
- 배열 리스트의 단점
    - 사용하지 않는 공간 낭비: 사용할 공간을 정확히 예측하지 못하면 나머지 공간이 낭비됨
    - 배열의 마지막 데이터 수정/삭제(`O(1)`)를 제외한 나머지의 경우(`O(n)`) 성능이 좋지 않음
# I. 노드(Node)와 연결(Link)
- 필요한 만큼 만들고, 중간에 연결 부분만 만지면 되지 않을까? -> 노드
- 데이터를 저장하는 부분과 함께 다른 노드의 정보를 담는 부분으로 구성
```java
public class Node{
    Object item; //데이터 보관
    Node next;//다음 데이터의 인스턴스 주소(참조값)
}
```
![Node](../../img/middle/CollectionFrameworks/Node01.png)
- [노드 클래스](../../../src/step04_middleClass2/chapter02_CollectionFramework/linkedList/Node.java)
```java
public static void main(String[] args) {
// A -> B -> C
Node first = new Node("A");
first.setNext(new Node("B"));//second
first.getNext().setNext(new Node("C"));//third
System.out.println("First Node: " + first.getItem());
System.out.println("Second Node: " + first.getNext().getItem());
System.out.println("Third Node: " + first.getNext().getNext().getItem());
}
```
- 모든 노드 순회하기
  - `next`가 `null`이면 종료
```java
public static void main(String[] args) {
    System.out.println("## iterate all node");
    Node currentReference = first;
    int count = 0;
    while (currentReference != null) {
        System.out.println((++count)+". " + currentReference.getItem());
        currentReference = currentReference.getNext();
    }
}
```
# II. 기능 추가
## A. override toString method
- 좀 더 보기 좋게 toString 재정의
```java
@Override
public String toString() {
    StringBuffer sb = new StringBuffer();
    Node current = this;
    sb.append("[");
    while (current != null) {
        sb.append(current.getItem());
        if(current.getNext() != null)
            sb.append(" -> ");
        current = current.getNext();
    }
    sb.append("]");
    return sb.toString();
}
```
## B. 기타 기능 추가하기
- 추가할 기능
  - 데이터로 노드 검색하기
  - 마지막 노드 조회하기
  - 특정 index의 노드 조회하기
  - 노드 리스트에 데이터 추가하기
### 1. 데이터로 노드 검색
```java
private static int indexOf(Node n, Object o) {
    int i = 0;
    while (n != null) {
        if(o.equals(n.getItem()))
            return i;
        i++;
        n = n.getNext();
    }
    return -1;
}
```
### 2. 마지막 노드 조회하기
```java
private static Node getLastNode(Node targetNode) {
    while (targetNode.getNext() != null) {
        targetNode = targetNode.getNext();
    }
    return targetNode;
}
```
### 3. 특정 index의 노드 조회하기
```java
private static Node findNodeByIdx(Node n, int idx) {
    for (int i = 0; i < idx; i++) {
        if(n.getNext()==null) {
            System.out.println("index " + i + "가 마지막입니다. 요청한 index: " + idx);
            return n;
        }
        n=n.getNext();
    }
    return n;
}
```
### 4. 노드 리스트에 데이터 추가하기
```java
private static void addNode(Node n, Object o) {
    while (n.getNext() != null) {
        n = n.getNext();
    }
    n.setNext(new Node(o));
}
```
# III. 직접 LinkedList 만들기
- 배열을 사용하지 않고 노드와 연결 구조를 통해 만드는 연결리스트(Linked list)
  - 배열리스트의 단점 처리
    - 정확한 크기를 모를때 메모리 낭비 문제
      - 단 노드 정보를 위한 메모리가 추가로 요구됨
    - 중간위치 데이터 추가/제거에 대한 성능 문제 
- List 자료구조의 특성
  - 순서가 있음
  - 중복 허용
- 배열 리스트와 연결 리스트의 내부구조는 다르나 사용자 입장에서는 위의 특성만 있으면 크게 신경쓰지 않는다. 다만 주로 사용하는 기능에 따라 성능을 고려해 사용하면 됨

## A. [MyLinkedList](../../../src/step04_middleClass2/chapter02_CollectionFramework/linkedList/MyLinkedListV0.java): Basic
- 기본 기능
  - `void add(Object)`: 새로운 노드 추가
    - head 노드가 없으면 first에 추가
    - 기존 노드가 있으면 마지막에 추가
  - `Object set(int index, Object element)`: 노드 값 변경
    - 특정 index 값 변경, 기존 값 반환
  - `Object get(int index)`: index 기준 노드의 값 반환
  - `int indexOf(Object o)`: 데이터 검색
    - `equals()`를 사용해 검색, index 반환
    - 일치하는 데이터가 없으면 -1 반환
- MyArrayList에서 테스트한 기능을 그대로 사용 가능
  - 내부 구조는 다르지만 지원하는 기능(param, return)은 동일
  - 배열을 사용하지 않기때문에 사이즈에 대한 동적 할당을 지원
- 연결리스트의 시간복잡도
  - `get(index)`: index를 써도 자료를 하나씩 순회 후 꺼냄
  - `add(element)`: 리스트 끝에 넣을때도 노드를 따라 순회
  - 비교 표
  
| arrayList | method               | linkedList |
|----------|----------------------|------------|
| O(1)     | `get(index)`         | O(n)       |
| O(1)     | `add(element)`       | O(n)       |
| O(n)     | `set(index,element)` | O(n)       |
| O(n)     | `indexOf(element)`   | O(n)       |

## B. [MyLinkedList](../../../src/step04_middleClass2/chapter02_CollectionFramework/linkedList/MyLinkedListV1.java): 추가와 삭제
- 링크드 리스트를 사용하는 이유
  - 중간 데이터 추가 및 삭제
    - `void add(int index, Object element)`: 해당 위치의 연결(prev, next)을 새로 추가하는 노드로 변경
      - 새 노드의 next를 prev가 가지고있던 next로, prev의 next를 새 노드로
      - ex) `newNode.next = prevNode.next`, `prevNode.next = newNode`
      - 데이터 이동없이 논리적으로 처리
    - `Object remove(int index)`: 해당 위치의 prev 노드와 next 노드를 연결하고 제거
      - prev의 next를 제거 대상 노드의 next로 변경(targetNode 연결 제거됨)
      - ex) `prevNode.next = targetNode.next`
      - 마찬가지로 데이터 이동 없이 사용 가능
  - 검색은 O(n)이지만 처리는 O(1)
- 뭘써야하나? 
  - 데이터를 조회할 일이 많고 뒷부분에 데이터를 추가한다면 배열리스트가 더 유리
  - 앞쪽의 데이터를 추가하거나 삭제할 일이 많다면 연결리스트가 더 유리

| arrayList | method    | linkedList |
|-----------|-----------|------------|
| O(1)      | 인덱스 조회    | O(n)       |
| O(n)      | 검색        | O(n)       |
| O(n)      | 앞에 추가(삭제) | O(1)       |
| O(1)      | 뒤에 추가(삭제) | O(n)       |
| O(n)      | 평균 추가(삭제) | O(n)       |
- 지금 구현한 것은 단일 연결 리스트
  - 단일 연결리스트: 단 방향으로만 이동하는 연결 리스트
  - 자바가 제공하는 연결리스트는 이중 연결 리스트
    - 또한 마지막 노드를 참조하는 변수를 지니고 있어 뒷쪽 데이터를 추가하거나 삭제할때도 O(1)의 성능을 제공
    ```java
    public class Node{
        private Node head;// 첫 노드
        private Node tail;// 끝 노드
        private Object item;
    }
    ```
## C. [MyLinkedList](../../../src/step04_middleClass2/chapter02_CollectionFramework/linkedList/MyLinkedListV2.java): 제네릭
- 노드는 내부에서만 사용되므로 중첩 클래스로 적용해 봄
  - `Node<E>` 생성
  - 외부 클래스에 generic 적용
  - 각 메서드에 generic type 적용
# IV. 다음으로
- java가 제공하는 [List](../../04middle-2/CollectionFramework/04List.md)
  - List interface 적용
  - 성능비교
- [전체 코드](../../../src/step04_middleClass2/chapter02_CollectionFramework/linkedList)