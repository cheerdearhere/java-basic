package step04_middleClass2.chapter01_Generic.test.ex02_starcraft;

import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.BioUnit;

public class UnitPrinter {
    static <T extends BioUnit> void printV1(Shuttle<T> shuttle){
//        shuttle.showInfo();
        T unit = shuttle.out();
        System.out.println("이름: "+unit.getName()+", HP: "+unit.getHp());
    }
    static void printV2(Shuttle<? extends BioUnit> shuttle){
//        shuttle.showInfo();
        BioUnit unit = shuttle.out();
        System.out.println("이름: "+unit.getName()+", HP: "+unit.getHp());
    }
}
