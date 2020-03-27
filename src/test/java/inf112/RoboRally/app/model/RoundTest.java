package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Round;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundTest {

    private Round round;
    private Player[] players;

    @Before
    public void setup() {
        players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        round = new Round(players, players[0]);
    }



    @Test
    public void playerGetsDealtACard() {
        // players have not yet been dealt any cards
        for (Player player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            for (int i = 0; i < receivedCards.length; i++)
                assertEquals(true, receivedCards[i] == null);
        }

        round.dealCards();
        for (Player player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            for (int i = 0; i < receivedCards.length; i++) {
                assertEquals(true, receivedCards[i] != null);
                assertEquals(true, receivedCards[i] instanceof ICard);
                assertEquals(true, receivedCards[i].priority() >= 0);
            }
        }

    }


}
