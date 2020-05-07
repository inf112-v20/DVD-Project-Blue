package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.IRobot;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private CardFactory cardFactory;

    @Before
    public void setup() {
        cardFactory = new CardFactory();
        player = new Player(0, new Pos(5,5), Direction.RIGHT);
    }

    @Test
    public void constructorTest() {
        assertEquals(0, player.getPlayerNumber());
        assertEquals(true, player.robot() instanceof IRobot);
        assertEquals(true, player.getDealtCards() instanceof ICard[]);
        assertEquals(true, player.getCardSlots() instanceof ICard[]);
        assertEquals(player.getDealtCards().length, player.numberOfReceivedCards());
        assertEquals(player.getCardSlots().length, player.numberOfCardSlots());
        assertEquals(5, player.numberOfCardSlots());
        assertEquals(9, player.numberOfReceivedCards());
        assertEquals(true, player.isBotPlayer()); // players are bots unless told otherwise

    }

    @Test
    public void playerStartsWithNoCards() {
        for (ICard card: player.getDealtCards())
            assertEquals(null, card);
        for (ICard card: player.getCardSlots())
            assertEquals(null, card);

    }

    @Test
    public void testPlayerCanBeDealtACard() {
        player.receiveCard(0, cardFactory.randomCard());
        assertEquals(false, player.getDealtCards()[0] == null);

    }

    @Test
    public void testPlayerCanBeDealtNineCards() {
        for (int i = 0; i < player.numberOfReceivedCards(); i++)
            player.receiveCard(i, cardFactory.randomCard());

        for (ICard card: player.getDealtCards()) {
            assertEquals(false, card == null);
        }
    }

    @Test
    public void testBotPlayerChoosesCards() {

        // player must receive cards first - player must have cards too choose from
        for (int i = 0; i < player.numberOfReceivedCards(); i++)
            player.receiveCard(i, cardFactory.randomCard());

        player.botPlayerChooseCardsForCardSlots();
        for (ICard card: player.getCardSlots())
            assertEquals(true, card != null);

    }





}
