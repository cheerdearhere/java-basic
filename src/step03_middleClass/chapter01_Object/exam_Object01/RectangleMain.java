package step03_middleClass.chapter01_Object.exam_Object01;

/*
문제: toString(), equals() 구현하기
문제 설명
다음 코드와 실행 결과를 참고해서 Rectangle 클래스를 만들어라.
Rectangle 클래스에 IDE의 기능을 사용해서 toString() , equals() 메서드를 실행 결과에 맞도록 재정
의해라.
rect1 과 rect2 는 넓이( width )와 높이( height )를 가진다. 넓이와 높이가 모두 같다면 동등성 비교에 성
공해야 한다.

package lang.object.test;
public class RectangleMain {
 public static void main(String[] args) {
 Rectangle rect1 = new Rectangle(100, 20);
 Rectangle rect2 = new Rectangle(100, 20);
 System.out.println(rect1);
 System.out.println(rect2);
 System.out.println(rect1 == rect2);
 System.out.println(rect1.equals(rect2));
 }
}

실행 결과
Rectangle{width=100, height=20}
Rectangle{width=100, height=20}
false
true
 */
public class RectangleMain {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(100, 20);
        Rectangle rect2 = new Rectangle(100, 20);
        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println(rect1 == rect2);
        System.out.println(rect1.equals(rect2));
    }
}
