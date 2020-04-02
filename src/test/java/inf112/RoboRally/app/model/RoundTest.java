package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Round;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundTest {

    private Round round;
    private Game game;
    private Player[] players;

    @Before
    public void setup() {
        SinglePlayerSettingsController settings = new SinglePlayerSettingsController();
        // four players
        for (int i = 0; i < 2; i++)
            settings.choosePlayerCount();
        game = new Game(settings);
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
        for (Player player: players) {
            ICard card = player.getReceivedCards()[0];
            assertEquals(true, player == card.getPlayer());
            assertEquals(false, card == null);
            assertEquals(true, player.getReceivedCards()[0] instanceof ICard);
        }

    }


    @Test
    public void eachPlayerGetsDealtTheCorrectNumberOfCards() {
        round.dealCards();
        for (Player player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            for (int i = 0; i < player.amountOfReceivedCards(); i++) {
                ICard card = receivedCards[i];
                assertEquals(true, player == card.getPlayer());
                assertEquals(false, card == null);
                assertEquals(true, card instanceof ICard);
            }
        }
        for (Player player: players) {
            player.robot().looseHP();
            player.robot().looseHP();
        }
        // each player has lost two HP, therefore, the last two cards should now be null
        round.dealCards();
        for (Player player: players) {
            ICard[] receivedCards = player.getReceivedCards();
            assertEquals(true,receivedCards.length != player.amountOfReceivedCards());
            for (int i = 0; i < receivedCards.length; i++) {
                ICard card = receivedCards[i];
                if (i < 7) {
                    assertEquals(true, card != null);
                    assertEquals(true, card instanceof ICard);
                }
                else if (i == 9 || i == 8)
                    assertEquals(true, card == null);
            }
        }

    }



    @Test
    public void cardExecutionTest() {
        CardFactory cardFactory = new CardFactory();
        for (Player player: players) {
            ICard[] cardSlots = player.getCardSlots();
            for (int i = 0; i < player.numberOfCardSlots(); i++) {
                cardSlots[i] = cardFactory.randomCard();
                cardSlots[i].setPlayer(player);
            }

        }
        Pos[] initPositions = new Pos[4];
        for (int i = 0; i < players.length; i++) {
            int x = players[i].robot().position().x();
            int y = players[i].robot().position().y();
            initPositions[i] = new Pos(x, y);
//            System.out.println(initPositions[i].getX()+", "+initPositions[i].getY());
        }
        round.executeCardChoices();
        int differentPositionCount = 0;
        for (int i = 0; i < players.length; i++) {
            System.out.println(initPositions[i].x()+", "+initPositions[i].y());
            if (initPositions[i] != players[i].robot().position())
                differentPositionCount++;
        }
        // tests that more than two players will have moved to new positions, theoretically it
        // is possible that every player can perform a move sequence to its initial position.
        // Therefore, it only checks that at least to robots have moved to different positions.
        // But you could change the value '3' to '4', and tests still pass 99/100 times.
        assertEquals(true, differentPositionCount >= 3);
    }



}
