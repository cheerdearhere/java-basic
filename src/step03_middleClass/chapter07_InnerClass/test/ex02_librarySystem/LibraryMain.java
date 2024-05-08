package step03_middleClass.chapter07_InnerClass.test.ex02_librarySystem;
/*
문제: 도서 관리 시스템
도서관에서 사용할 수 있는 간단한 도서 관리 시스템을 만들어 보자. 이 시스템은 여러 권의 도서 정보를 관리할 수 있어
야 한다. 각 도서는 도서 제목( title )과 저자명( author )을 가지고 있다. 시스템은 도서를 추가하고, 모든 도서의 정
보를 출력하는 기능을 제공해야 한다.
    Library 클래스를 완성해라.
    LibraryMain 과 실행 결과를 참고하자.
    Book 클래스는 Library 내부에서만 사용된다. Library 클래스 외부로 노출하면 안된다.
    Library 클래스는 Book 객체 배열을 사용해서 도서 목록을 관리한다.

package nested.test.ex1;
public class Library {
 //코드 작성
}

package nested.test.ex1;
public class LibraryMain {
 public static void main(String[] args) {
 Library library = new Library(4); // 최대 4권의 도서를 저장할 수 있는 도서관 생성
 library.addBook("책1", "저자1");
 library.addBook("책2", "저자2");
 library.addBook("책3", "저자3");
 library.addBook("자바 ORM 표준 JPA 프로그래밍", "김영한");
 library.addBook("OneMoreThing", "잡스");
 library.showBooks(); // 도서관의 모든 도서 정보 출력
 }
}

실행 결과
    도서관 저장 공간이 부족합니다.
    == 책 목록 출력 ==
    도서 제목: 책1, 저자: 저자1
    도서 제목: 책2, 저자: 저자2
    도서 제목: 책3, 저자: 저자3
    도서 제목: 자바 ORM 표준 JPA 프로그래밍, 저자: 김영한
 */
public class LibraryMain {
    public static void main(String[] args) throws Exception {
        Library library = new Library(4); // 최대 4권의 도서를 저장할 수 있는 도서관 생성
        library.addBook("책1", "저자1");
        library.addBook("책2", "저자2");
        library.addBook("책3", "저자3");
        library.addBook("자바 ORM 표준 JPA 프로그래밍", "김영한");
        library.addBook("OneMoreThing", "잡스");
        library.showBooks(); // 도서관의 모든 도서 정보 출력
    }
}
