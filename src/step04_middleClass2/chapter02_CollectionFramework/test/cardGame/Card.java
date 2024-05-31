package step04_middleClass2.chapter02_CollectionFramework.test.cardGame;

public class Card implements Comparable<Card>{
    private final int rank;
    private final Suit suit;
    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        // 숫자 우선
        if(this.rank != o.rank)
            return Integer.compare(this.rank, o.rank);
        // 그외 == 문양 Enum은 선언 순서로 비교
        else
            return this.suit.compareTo(o.suit);
    }

    @Override
    public String toString() {
        return rank + "(" + suit.getSymbol() + ")";
    }
}
