package step04_middleClass2.chapter01_Generic.test.ex02_starcraft.Units;

public class BioUnit {
    private String name;
    private int hp;
    public BioUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    @Override
    public String toString() {
        return "BioUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
