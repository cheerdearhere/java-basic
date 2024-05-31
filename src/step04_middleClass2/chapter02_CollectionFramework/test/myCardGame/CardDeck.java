package step04_middleClass2.chapter02_CollectionFramework.test.myCardGame;

import java.util.*;
import java.util.stream.IntStream;

public class CardDeck {
    private final ArrayList<Card> deck;

    public CardDeck() {
        deck = getBasicDeck();
    }
    public Card drowCard(){
        return deck.removeFirst();
    }

    private ArrayList<Card> getBasicDeck() {
        List<CardIcon> cardIcons = List.of(CardIcon.SPAID,CardIcon.HEART,CardIcon.DIAMOND,CardIcon.CLUB);
        ArrayList<Card> basicDeck = new ArrayList<>();
        for(CardIcon cardIcon : cardIcons){
            basicDeck.addAll(
                    IntStream.range(1,14)
                        .mapToObj(num->new Card(num,cardIcon))
                        .toList()
            );
        }
        Collections.shuffle(basicDeck);
        return basicDeck;
    }

    @Override
    public String toString() {
        return "rest card deck("+deck.size()+"): " + deck;
    }
}
