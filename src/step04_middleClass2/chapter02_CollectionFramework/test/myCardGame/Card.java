package step04_middleClass2.chapter02_CollectionFramework.test.myCardGame;

import java.util.Objects;

public class Card implements Comparable<Card>{
    private int number;
    private CardIcon icon;
    public Card(int number, CardIcon icon){
        this.number = number;
        this.icon = icon;
    }

    public int getNumber(){
        return number;
    }
    public CardIcon getIcon(){
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return this.toString().equals(card.toString());
    }
    @Override
    public int hashCode() {
        return Objects.hash(number, icon);
    }
    @Override
    public String toString() {
        return String.format("%d(%s)", number, icon.getIconCode());
    }
    @Override
    public int compareTo(Card o) {
        if(this.number == o.number){
            int thisIconIndex = this.icon.getIndex();
            int otherIconIndex = o.icon.getIndex();
            return Integer.compare(thisIconIndex, otherIconIndex);
        }
        else{
            return Integer.compare(this.number, o.number);
        }
    }
}
