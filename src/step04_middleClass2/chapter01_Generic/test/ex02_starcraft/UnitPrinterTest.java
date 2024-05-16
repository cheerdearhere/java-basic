package step04_middleClass2.chapter01_Generic.test.ex02_starcraft;

import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Marine;
import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Zealot;
import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Zergling;

/*
문제와 풀이3 - 제네릭 메서드와 와일드카드
문제 설명
    앞서 문제에서 만든 Shuttle 을 활용한다.
    다음 코드와 실행 결과를 참고해서 UnitPrinter 클래스를 만들어라.
    UnitPrinter 클래스의 조건은 다음과 같다.
    UnitPrinter.printV1() 은 제네릭 메서드로 구현해야 한다.
    UnitPrinter.printV2() 는 와일드카드로 구현해야 한다.
    이 두 메서드는 셔틀에 들어있는 유닛의 정보를 출력한다.

package generic.test.ex3;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;
public class UnitPrinterTest {
 public static void main(String[] args) {
 Shuttle<Marine> shuttle1 = new Shuttle<>();
 shuttle1.in(new Marine("마린", 40));
 Shuttle<Zergling> shuttle2 = new Shuttle<>();
 shuttle2.in(new Zergling("저글링", 35));
 Shuttle<Zealot> shuttle3 = new Shuttle<>();
 shuttle3.in(new Zealot("질럿", 100));
 UnitPrinter.printV1(shuttle1);
 UnitPrinter.printV2(shuttle1);
 }
}

실행 결과
    이름: 마린, HP: 40
    이름: 마린, HP: 40
 */
public class UnitPrinterTest {
    public static void main(String[] args) {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));
        Shuttle<Zergling> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zergling("저글링", 35));
        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("질럿", 100));
        UnitPrinter.printV1(shuttle1);
        UnitPrinter.printV2(shuttle1);
    }
}
