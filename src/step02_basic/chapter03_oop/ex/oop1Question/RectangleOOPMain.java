package step02_basic.chapter03_oop.ex.oop1Question;

public class RectangleOOPMain {
    /*
문제1 - 절차 지향 직사각형 프로그램을 객체 지향으로 변경하기
    다음은 직사각형의 넓이(Area), 둘레 길이(Perimeter), 정사각형 여부(square)를 구하는 프로그램이다.
    절차 지향 프로그래밍 방식으로 되어 있는 코드를 객체 지향 프로그래밍 방식으로 변경해라.
    Rectangle 클래스를 만들어라.
    RectangleOopMain 에 해당 클래스를 사용하는 main() 코드를 만들어라.
절차 지향 코드 : RectangleProceduralMain.java

실행 결과
    넓이: 40
    둘레 길이: 26
    정사각형 여부: false
*/
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        int width=5;
        int height=8;
        rectangle.setRectangle(width, height);
        System.out.println("넓이: " + rectangle.calculateArea());
        System.out.println("둘레 길이: " + rectangle.calculatePerimeter());
        System.out.println("정사각형 여부: " +rectangle.isSquare());
    }
}
