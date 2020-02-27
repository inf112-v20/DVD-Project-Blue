package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.*;

import java.util.ArrayList;
import java.util.Random;
/*
Class that holds all the cards in the game, which will be used when dealing cards to players.
Not used at this moment.
 */
public class CardDeck {

    private ArrayList<Card> deck = new ArrayList<>();

    public CardDeck() {
        deck.add(new ForwardCard(800, 3));
        deck.add(new ReverseCard(600));
        deck.add(new ForwardCard(1000, 4));
        deck.add(new RotateCard(1300, Rotation.LEFT));
        deck.add(new RotateCard(1500, Rotation.RIGHT));
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
        CardDeck deck = new CardDeck();
        deck.getRandomCardFromDeck();
    }
}
