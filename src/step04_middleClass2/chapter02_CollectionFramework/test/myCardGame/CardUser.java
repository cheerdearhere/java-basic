package step04_middleClass2.chapter02_CollectionFramework.test.myCardGame;

import java.util.ArrayList;

public class CardUser {
    private final ArrayList<Card> cards = new ArrayList<>();
    private String userId;
    private int takeCount;
    private int score;

    public CardUser(String userId) {
        this.userId = userId;
        takeCount = 5;
    }
    public CardUser(String userId,int takeCount) {
        if(takeCount > 52) {
            System.out.println("카드는 52장뿐입니다");
        }
        this.userId = userId;
        this.takeCount = takeCount;
    }
    public void setRule(int takeCount) {
        if(takeCount > 52) {
            System.out.println("카드는 52장뿐입니다");
        }
        System.out.println("카드 드로우 횟수를 지정합니다: "+takeCount);
        this.takeCount = takeCount;
    }
    public void getCards(Card card){
        if(takeCount == cards.size()){
            System.out.println("뽑을 수 있는 카드 숫자가 최대입니다: "+ takeCount);
            return;
        }

        cards.add(card);
//        System.out.println(userId+"의 차례("+cards.size()+"): "+card);
        cards.sort(null);
        score+=card.getNumber();
    }
    public void resetGame(CardDeck deck){
        cards.clear();
        for(int i = 0; i < takeCount; i++){
            getCards(deck.drowCard());
        }
    }
    public void gameResult(CardUser cardUser) {
        if(this==cardUser) System.out.println("본인과 승부를 낼 수 없습니다.");
        else if(this.cards.size() != cardUser.cards.size()){
            System.out.println("카드 수가 맞지 않습니다: 당신 - "+this.cards.size()+"/ 상대 - "+cardUser.cards.size());
        }
        else {
            int myScore = this.score;
            int otherScore = cardUser.score;
            System.out.println(
                    (myScore == otherScore)
                            ? "무승부"
                            : (myScore>otherScore? this.userId: cardUser.userId)+" 승리"
            );
        }

    }

    @Override
    public String toString() {
        return String.format("%s의 카드(%d): %s, 합계: %d", userId, cards.size(), cards, score);
    }
}
