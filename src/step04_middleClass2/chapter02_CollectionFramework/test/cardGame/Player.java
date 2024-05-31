package step04_middleClass2.chapter02_CollectionFramework.test.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addCard(Card card) {
        hand.add(card);
    }
    public void drawCard(Deck deck) {
        hand.add(deck.drawCard());
    }
    public int rankSum() {
        int sum = 0;
        for (Card card : hand) {
            sum += card.getRank();
        }
        return sum;
    }
    public void showHand(){
        hand.sort(null);
        System.out.println(name+"의 카드: "+ hand + ", 합계: "+rankSum());
    }
}
