package step04_middleClass2.chapter01_Generic.test.ex02_starcraft;

import step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units.BioUnit;

public class Shuttle <T extends BioUnit>{
    private T unit;
    public void in(T unit){
        this.unit = unit;
    }
    public T out(){
        return unit;
    }
    public void showInfo(){
        System.out.printf("이름: %s, HP: %d\n",unit.getName(),unit.getHp());
    }
}
