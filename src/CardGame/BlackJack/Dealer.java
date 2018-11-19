package CardGame.BlackJack;

import CardGame.Card;
import CardGame.CardDeck;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    // 딜러가 가지고 있는 카드
    private List<Card> cards;

    // 딜러가 가지고 있는 카드 덱 (사용자에게 덱에서 1장씩 나눠줌)
    private CardDeck cardDecks;

    public Dealer() {
        /*초기화부분
        * cards --> 원하는 리스트로
        * cardDeck --> 구현한 CardDeck으로 초기화
        * */
    }

    public void init(List<User> users) {
        cards = new ArrayList<>();
        cardDecks = new CardDeck();
        cardDecks.shuffle();

        for (User u : users) {
            this.handOut(u);
            this.handOut(u); // 카드 2장을 나눠줌
        }
        cards.add(cardDecks.draw());
        cards.add(cardDecks.draw());
    }

    // 유저들에게 카드를 나눠 줌 유저를 입력으로 받고, 카드덱에서 카드를 뽑아 카드를 건네줌.
    public void handOut(User user) {
        user.hit(cardDecks.draw());
    }

    // 딜러의 현재 카드 수의 합이 16 이하이면 무조권 1장 받아옴 false 리턴
    public boolean hit() {
        cards.add(this.cardDecks.draw());
        return false;
    }

    // 딜러의 카드 수의 합이 17 이상이면 statnd, true 리턴

    public boolean stand() {
        return true;
    }

    public int getTotalNum() {
        int result = 0;
        for (Card c : cards)
            result += c.getNum();
        return result;
    }

    public int getCurrentNum() {
        int result = 0;
        for (int i = 1; i < cards.size(); i++)
            result += cards.get(i).getNum();
        return result;
    }

    @Override
    public String toString() {
        // 딜러의 현재 카드를 보여줌 --> 0번쨰 카드는 * 처리(숨김) 1번째 카드는 card의 toString이용
        String s = "((*), ";
        for (int i = 1; i < cards.size(); i++) {
            s += cards.get(i).toString();
        }
        return s + ")";
    }
}
