package step04_middleClass2.chapter02_CollectionFramework.test.cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    public Deck() {
        initCard();
        Collections.shuffle(cards);
    }
    public Card drawCard(){
        return cards.removeFirst();
    }
    private void initCard(){
        for(int i = 1; i <= 13; i++){
            for(Suit value: Suit.values()){
                cards.add(new Card(i,value));
            }
        }
    }
}
