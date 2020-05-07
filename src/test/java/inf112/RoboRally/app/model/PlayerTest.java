package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private CardFactory cardFactory;

    @Before
    public void setUp() {
        cardFactory = new CardFactory();
        player = new Player(0, new Pos(5,5), Direction.RIGHT);
    }

    @Test
    public void constructorCardTest() {

        assertEquals(0, player.getPlayerNumber());
        assertNotNull(player.getDealtCards());
        assertNotNull(player.getCardSlots());
        assertEquals(player.getDealtCards().length, player.numberOfReceivedCards());
        assertEquals(player.getCardSlots().length, player.numberOfCardSlots());
        assertEquals(5, player.numberOfCardSlots());
        assertEquals(9, player.numberOfReceivedCards());
        assertTrue(player.isBotPlayer()); // players are bots unless told otherwise

    }

    @Test
    public void constructorRobotTest() {

        assertNotNull(player.robot());
        assertEquals(5, player.robot().pos().getX());
        assertEquals(5, player.robot().pos().getY());
        assertEquals(Direction.RIGHT, player.robot().direction());

    }

    @Test
    public void playerStartsWithNoCards() {
        for (ICard card: player.getDealtCards())
            assertNull(card);
        for (ICard card: player.getCardSlots())
            assertNull(card);

    }

    @Test
    public void testPlayerCanBeDealtACard() {
        player.receiveCard(0, cardFactory.randomCard());
        assertNotNull(player.getDealtCards()[0]);

    }

    @Test
    public void testPlayerCanBeDealtNineCards() {
        for (int i = 0; i < player.numberOfReceivedCards(); i++)
            player.receiveCard(i, cardFactory.randomCard());

        for (ICard card: player.getDealtCards()) {
            assertNotNull(card);
        }
    }

    @Test
    public void testBotPlayerChoosesCards() {

        // player must receive cards first - player must have cards too choose from
        for (int i = 0; i < player.numberOfReceivedCards(); i++)
            player.receiveCard(i, cardFactory.randomCard());

        player.botPlayerChooseCardsForCardSlots();
        for (ICard card: player.getCardSlots())
            assertNotNull(card);

    }


    @Test
    public void playerClearCardsTest() {

        // player must receive cards first - player must have cards too choose from
        for (int i = 0; i < player.numberOfReceivedCards(); i++)
            player.receiveCard(i, cardFactory.randomCard());

        player.botPlayerChooseCardsForCardSlots();
        for (ICard card: player.getCardSlots())
            assertNotNull(card);

        player.resetCards();

        for (ICard card: player.getCardSlots())
            assertNull(card);
        for (ICard card: player.getDealtCards())
            assertNull(card);


    }

    @Test
    public void playerGetsDealtLessCardsAfterRobotLoosesHP() {
        player.getDealtCards();
        assertEquals(9, player.numberOfReceivedCards());
        player.resetCards();
        player.robot().looseHP(5);
        player.getDealtCards();
        assertEquals(5, player.numberOfReceivedCards());

    }

    @Test
    public void playerDoesNotGetDealtAnyCardsWhenRobotIsDead() {
        player.robot().looseHP(10);
        player.robot().looseHP(10);
        player.robot().looseHP(10);
        player.getDealtCards();
        assertEquals(0, player.numberOfReceivedCards());
    }







}
