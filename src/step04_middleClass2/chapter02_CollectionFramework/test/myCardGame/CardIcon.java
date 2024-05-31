package step04_middleClass2.chapter02_CollectionFramework.test.myCardGame;

public enum CardIcon {
    // Enum은 이미 compareTo가 선언 순서로 구현되어있다.
    // final로 선언되어있기때문에 변경할 수 없다
    SPAID("\u2660",0),
    HEART("\u2665", 1),
    DIAMOND("\u2666",2),
    CLUB("\u2663",3);
    private final String iconCode;
    private final int index;
    CardIcon(String iconCode, int index) {
        this.iconCode = iconCode;
        this.index = index;
    }
    public String getIconCode() {
        return this.iconCode;
    }
    public int getIndex() {
        return this.index;
    }
}
