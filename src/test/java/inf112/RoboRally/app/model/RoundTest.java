package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.NewGame;
import inf112.RoboRally.app.models.game.NewPlayer;
import inf112.RoboRally.app.models.game.Round;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundTest {

    private Round round;
    private NewGame game;
    private NewPlayer[] players;

    @Before
    public void setup() {
        SinglePlayerSettingsController settings = new SinglePlayerSettingsController();
        // four players
        for (int i = 0; i < 2; i++)
            settings.choosePlayerCount();
        game = new NewGame(settings);
        round = game.round();
        players = game.players();
    }

    @Test
    public void constructorTest() {
        assertEquals(false, round == null);
        assertEquals(true, round instanceof Round);
    }



    @Test
    public void eachPlayerGetsDealtACard() {
        round.dealCards();
        for (NewPlayer player: players) {
            ICard card = player.getReceivedCards()[0];
            assertEquals(true, player == card.getPlayer());
            assertEquals(false, card == null);
            assertEquals(true, player.getReceivedCards()[0] instanceof ICard);
        }

    }


    @Test
    public void eachPlayerGetsDealtTheCorrectNumberOfCards() {
        round.dealCards();
        for (NewPlayer player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            for (int i = 0; i < player.amountOfReceivedCards(); i++) {
                ICard card = receivedCards[i];
                assertEquals(true, player == card.getPlayer());
                assertEquals(false, card == null);
                assertEquals(true, card instanceof ICard);
            }
        }
        for (NewPlayer player: players) {
            player.robot().looseHP();
            player.robot().looseHP();
        }
        // each player has lost two HP, therefore, the last two cards should now be null
        round.dealCards();
        for (NewPlayer player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            assertEquals(true,receivedCards.length != player.amountOfReceivedCards());
            for (int i = 0; i < receivedCards.length; i++) {
                ICard card = receivedCards[i];
                if (i < 7) {
                    assertEquals(true, card != null);
                    assertEquals(true, card instanceof ICard);
                }
                else if (i == 8 || i == 7)
                    assertEquals(true, card == null);
            }
        }

    }



    @Test
    public void cardExecution() {
        
    }


}
