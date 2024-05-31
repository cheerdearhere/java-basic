package step04_middleClass2.chapter02_CollectionFramework.test.myCardGame;
/*
카드 게임을 만들어보자.
요구사항
    카드( Card )는 1 ~ 13까지있다. 각 번호당 다음 4개의 문양이 있다.
    ♠: 스페이드
    ♥: 하트
    䡫: 다이아
    ♣: 클로버
    예) 1(♠), 1(♥), 1(䡫), 1(♣), 2(♠), 2(♥), 2(䡫), 2(♣) ... 13(♠), 13(♥), 13(䡫), 13(♣)
    따라서 13 * 4 = 총 52장의 카드가 있다.
    52장의 카드가 있는 카드 뭉치를 덱( Deck )이라 한다.
    2명의 플레이어( Player )가 게임을 진행한다.
    게임을 시작하면 다음 순서를 따른다.
    1. 덱에 있는 카드를 랜덤하게 섞는다.
    2. 각 플레이어는 덱에서 카드를 5장씩 뽑는다.
    3. 각 플레이어는 5장의 카드를 정렬된 순서대로 보여준다. 정렬 기준은 다음과 같다.
    작은 숫자가 먼저 나온다.
    같은 숫자의 경우 ♠, ♥, 䡫, ♣ 순으로 정렬한다. ♠가 가장 먼저 나온다.
    예) 1(♠), 1(♥), 2(䡫), 3(♣) 순서로 출력된다.
    4. 카드 숫자의 합계가 큰 플레이어가 승리한다.
    게임을 단순화 하기 위해 숫자만 출력한다.
    합계가 같으면 무승부이다.

실행 결과 예시
    플레이어1의 카드: [2(♠), 7(♥), 7(♦), 8(♣), 13(♠)], 합계: 37
    플레이어2의 카드: [1(♠), 1(♣), 6(♠), 9(♠), 9(♣)], 합계: 26
    플레이어1 승리

    플레이어1의 카드: [2(♦), 3(♠), 6(♥), 10(♣), 13(♦)], 합계: 34
    플레이어2의 카드: [2(♠), 4(♣), 5(♠), 11(♣), 12(♥)], 합계: 34
    무승부

참고
스페이드, 하트 같은 아이콘을 직접 사용하기 어려운 경우 다음과 같이 \ (백슬래시 backslash)와 함께 다음 코드를 적
어주면 아이콘을 출력할 수 있다.
"\u2660" : 스페이드(♠)
"\u2665" : 하트(♥)
"\u2666" : 다이아몬드(䡫)
"\u2663" : 클로버(♣)
예) System.out.println("\u2660")

이 문제는 정해진 정답이 없다. 실행 결과 예시를 참고하되, 자유롭게 풀면 된다.
CardGameMain 에 main() 메서드를 만들고 시작하자. 필요하면 클래스를 추가해도 된다.
CardGameMain - 코드 작성
package collection.compare.test;
public class CardGameMain {
 public static void main(String[] args) {
 // 코드 작성
 }
}
 */
public class CardGameMain {
    public static void main(String[] args) {
        int cardCount = 5;
        CardUser user1 = new CardUser("플레이어1", cardCount);
        CardUser user2 = new CardUser("플레이어2", cardCount);

        int games = 10;
        for(int i = 0; i < games; i++) {
            startCardGame(user1, user2);
        }
    }
    private static void startCardGame(CardUser user1, CardUser user2){
        CardDeck deck = new CardDeck();
        user1.resetGame(deck);
        user2.resetGame(deck);
        System.out.println("결과");
        System.out.println(user1);
        System.out.println(user2);
        user1.gameResult(user2);
    }
}
