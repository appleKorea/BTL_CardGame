package CardGame.BlackJack;

import CardGame.Card;

import java.util.ArrayList;
import java.util.List;

public class User {
    // 유저가 가지고 잇는 카드들
    private String name;
    private List<Card> cards;
    // 더이상 카드를 받지 않을 경우 true
    private boolean finish;

    // 사용자가 가지고 있는 금액
    private double money;

    public User(String name) {
        /*초기화 부분
         * cards --> 원하는 리스트로
         * finish --> false
         * money --> 기초 시작자금 1000원으로
         * */
        cards = new ArrayList<>();
        finish = false;
        money = 1_000;
    }

    public String getName() {
        return name;
    }

    public void getMoney(double money) {
        this.money += money;
    }

    // 카드를 1장 받음 false 리턴
    public void hit(Card card) {
        cards.add(card);
    }

    // 더이상 카드를 받지 않음 true 리턴
    public void stand() {
        this.finish = true; // 턴 끝
    }

    public boolean isFinish() {
        return finish;
    }

    public void reset() {
        this.finish = false;
    }

    // 돈을 배팅 (한 판에 1번 배팅 기본 100원)
    public double bet(double money) {
        this.money -= money;
        return money;
    }

    // 현재 들고있는 총 카드 숫자들의 합
    public int getTotalNum() {
        int result = 0;
        for (Card c : cards) {
            result += c.getNum();
        }
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        for (Card c : cards)
            s += c.toString();
        // 사용자의 현재 카드정보를 보여줌 --> {(0번카드, 1번카드.... ,i번카드,): 전체 카드숫자의합}
        return "{" + s + "}";
    }
}
