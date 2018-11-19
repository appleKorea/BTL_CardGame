package CardGame.BlackJack;

import java.util.ArrayList;
import java.util.Iterator;

public class Table {
    public static final int MAX_USER = 4;

    public static final int WIN = 1;
    public static final int LOSE = 2;
    public static final int DRAW = 3;

    private ArrayList<User> users;
    private Dealer dealer;
    private Iterator<User> iter;

    public Table() {
        users = new ArrayList<>();
        dealer = new Dealer();
    }

    public void enterUser(User user) {
        users.add(user);
    }

    public void showTable(User u) {
        System.out.println("Dealer: " + dealer.toString() + "  " + dealer.getCurrentNum());
        System.out.println(u.getName() +": " + u.toString() + "  " + u.getTotalNum());
    }

    public void init() {
        for (User u : users) {
            u.bet(100); // 기본 100원 배팅
            u.reset();  // 다시 게임 시작
        }

        dealer.init(users); // 카드를 2장씩 나눠 줌
        iter = users.iterator(); // 차례를 나타내주는 iter

        for (User u : users) {
        }
    }

    public boolean isBurst(User u) {
        if (u.getTotalNum() > 21)
            return true;
        else
            return false;
    }

    public void user() {

    }

    // 유저가 승리 -->
    public void win(){}

    // 유저가 패배
    public void lose(){}
}
