package CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {
    private List<Card> deck;

    public CardDeck() {
        String[] suits = {"spade", "heart", "diamond", "club"};
        int max = 13;

        deck = new ArrayList<>();

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < max; j++)
                deck.add(new Card(suits[i], j + 1));
        }
    }

    public Card draw() {
        Card a = deck.get(deck.size() - 1);
        deck.remove(a);

        System.out.println("Draw: " + a);

        return a;
    }

    public void shuffle() {
        System.out.println("Shuffle....");

//        Collections.shuffle(deck);

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < deck.size()-1; i++) {
            Card a = deck.get(i);

            int randomNum = random.nextInt(deck.size() - 1);
            Card b = deck.get(randomNum);

            deck.remove(a);
            deck.remove(b);

            deck.add(i, b);
            deck.add(randomNum, a);
        }
    }

    public static void main(String[] args) {
        CardDeck a = new CardDeck();
        a.shuffle();
        a.draw();
        a.draw();
        a.draw();
        a.draw();
        a.draw();
        a.draw();
    }
}
