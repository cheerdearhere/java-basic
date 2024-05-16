package step04_middleClass2.chapter01_Generic.test.ex02_starcraft;

import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.BioUnit;

public class UnitUtil {
    static <T extends BioUnit> T maxHp(T unit1, T unit2) {
        return unit1.getHp() > unit2.getHp() ? unit1 : unit2;
    }
}
