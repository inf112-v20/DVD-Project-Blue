package inf112.RoboRally.app.models.cards;

import java.util.Random;
/*
Class that holds all the cards in the game, which will be used when dealing cards to players.
Not used at this moment.
 */
public class CardDeck {

    private ICard[] deck = {
        new ForwardCard(3),
        new ForwardCard(2),
        new ForwardCard(1),
        new ReverseCard(),
        new RotateCard(Rotation.LEFT),
        new RotateCard(Rotation.RIGHT),
    };

    public ICard randomCard() {
        Random r = new Random();
        int deckIndex = r.nextInt(deck.length);
        ICard card = deck[deckIndex];
        card.setPriority(r.nextInt(1999));
        return card;
    }

}
