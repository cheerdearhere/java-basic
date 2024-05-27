package step04_middleClass2.chapter02_CollectionFramework.test.set;

import java.util.HashSet;
import java.util.Set;

/*
문제5 - Equals, HashCode
문제 설명
RectangleTest , 실행 결과를 참고해서 다음 Rectangle 클래스를 완성하자.
Rectangle 클래스는 width , height 가 모두 같으면 같은 값으로 정의한다.
package collection.set.test;
public class Rectangle {
 private int width;
 private int height;
 // 코드 작성
}

package collection.set.test;
import java.util.HashSet;
import java.util.Set;
public class RectangleTest {
 public static void main(String[] args) {
 Set<Rectangle> rectangleSet = new HashSet<>();
 rectangleSet.add(new Rectangle(10, 10));
 rectangleSet.add(new Rectangle(20, 20));
 rectangleSet.add(new Rectangle(20, 20)); //중복
 for (Rectangle rectangle : rectangleSet) {
 System.out.println("rectangle = " + rectangle);
 }
 }
}
실행 결과
rectangle = Rectangle{width=10, height=10}
rectangle = Rectangle{width=20, height=20}
 */
public class SetTest5 {
    public static void main(String[] args) {
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(new Rectangle(10, 10));
        rectangleSet.add(new Rectangle(20, 20));
        rectangleSet.add(new Rectangle(20, 20)); //중복
        for (Rectangle rectangle : rectangleSet) {
            System.out.println("rectangle = " + rectangle);
        }
    }
}
