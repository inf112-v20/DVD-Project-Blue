package inf112.RoboRally.app.cards;

import java.util.ArrayList;
import java.util.Random;

public class cardDeck {

    private ArrayList<Card> deck = new ArrayList<>();

    public cardDeck() {
        deck.add(new forwardCard(800, 3));
        deck.add(new reverseCard(600));
        deck.add(new forwardCard(1000, 4));
        deck.add(new rotateCard(1300, Rotation.LEFT));
        deck.add(new rotateCard(1500, Rotation.RIGHT));
    }

    public Card getRandomCardFromDeck() {
        Random r = new Random();
        int number = r.nextInt(deck.size());
        return deck.get(number);
    }

    public Card getCardFromDeckByIndex(int index) {
        return deck.get(index);
    }



    public static void main(String[] args) {
        cardDeck deck = new cardDeck();
        deck.getRandomCardFromDeck();
    }
}
