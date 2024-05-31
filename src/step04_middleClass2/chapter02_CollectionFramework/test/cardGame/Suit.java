package step04_middleClass2.chapter02_CollectionFramework.test.cardGame;

public enum Suit {
    SPAID("\u2660"),
    HEART("\u2665"),
    DIAMOND("\u2666"),
    CLUB("\u2663");
    private String symbol;
    Suit(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
}
