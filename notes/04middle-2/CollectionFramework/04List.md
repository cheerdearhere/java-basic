
# I. List 추상화
- List 자료구조의 특징
  - 순서
  - 중복 허용
- ArrayList와 LinkedList
  - 모두 List의 특징을 사용자에게 제공
  - 내부구조가 배열을 사용하느냐 노드를 사용하느냐의 차이
    - 데이터 추가, 수정, 삭제가 자주 일어나는 경우 => 연결 리스트
    - 데이터 조회, 찾기가 자주 일어나는 경우 => 배열 리스트
- List interface를 사용해 ArrayList와 LinkedList를 구현
  - 다형성과 OCP를 적용
  ![리스트 인터페이스](../../img/middle/CollectionFrameworks/ListInterface.png)
# II. 직접 리스트 만들기
## A. 인터페이스 구현
- 인터페이스 도입
```java
public interface MyList <E>{
    int size();
    void add(E e);
    void add(int index, E e);
    E get(int index);
    E set(int index, E e);
    E remove(int index);
    int indexOf(E e);
}
```
- MyArrayList, MyLinkedList에 구현(`implement MyList`)
## B. 의존관계 주입
## C. 컴파일 타임, 런타임 의존관계
## D. 성능비교
# III. Collection framework: List