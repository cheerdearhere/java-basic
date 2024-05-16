package step04_middleClass2.chapter01_Generic.test.ex02_starcraft;

import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Marine;
import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Zealot;
import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.Zergling;

/*
문제 2 - 셔틀
문제 설명
다음 코드와 실행 결과를 참고해서 Shuttle 클래스를 만들어라.
Shuttle 클래스의 조건은 다음과 같다.
제네릭 타입을 사용해야 한다.
showInfo() 메서드를 통해 탑승한 유닛의 정보를 출력한다.

package generic.test.ex3;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;
public class ShuttleTest {
 public static void main(String[] args) {
 Shuttle<Marine> shuttle1 = new Shuttle<>();
 shuttle1.in(new Marine("마린", 40));
 shuttle1.showInfo();
 Shuttle<Zergling> shuttle2 = new Shuttle<>();
 shuttle2.in(new Zergling("저글링", 35));
 shuttle2.showInfo();
 Shuttle<Zealot> shuttle3 = new Shuttle<>();
 shuttle3.in(new Zealot("질럿", 100));
 shuttle3.showInfo();
 }
}

실행 결과
이름: 마린, HP: 40
이름: 저글링, HP: 35
이름: 질럿, HP: 100
 */
public class ShuttleTest {
    public static void main(String[] args) {
        Shuttle<Marine> shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("마린", 40));
        shuttle1.showInfo();
        Shuttle<Zergling> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zergling("저글링", 35));
        shuttle2.showInfo();
        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("질럿", 100));
        shuttle3.showInfo();
    }
}
