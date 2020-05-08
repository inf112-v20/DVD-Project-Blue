package inf112.RoboRally.app.game;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Round;
import inf112.RoboRally.app.models.game.executors.RoundPhaseExecutor;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoundPhaseExecutorTest {

    private RoundPhaseExecutor roundPhaseExecutor;
    private Player[] players;
    private Round round;

    @Before
    public void setUp() {
        // setting up the players
        Player player1 = new Player(0, new Pos(4, 4), Direction.RIGHT);
        Player player2 = new Player(0, new Pos(4, 6), Direction.RIGHT);
        Player player3 = new Player(0, new Pos(4, 8), Direction.RIGHT);
        Player player4 = new Player(0, new Pos(4, 10), Direction.RIGHT);

        players = new Player[4];
        players[0] = player1; players[1] = player2; players[2] = player3; players[3] = player4;

        round = new Round(players);
        round.dealCardsAndBotsChooseCards();

        roundPhaseExecutor = new RoundPhaseExecutor(players, null ,null);
    }

    @Test
    public void testRoundPhaseExecutorCollectCardsFromSlotNumber() {
        ArrayList<ICard> cardsInFirstSlotNumber = roundPhaseExecutor.collectCardsFromSlotNumber(0);
        for (ICard card: cardsInFirstSlotNumber) {
            assertNotNull(card);
        }

    }

    @Test
    public void afterCardsAreCollectedFromCardSlotsTheCardIsRemovedFromThePlayerCardSlot() {
        ArrayList<ICard> cardsInFirstSlotNumber = roundPhaseExecutor.collectCardsFromSlotNumber(0);
        for (ICard card: cardsInFirstSlotNumber) {
            assertNotNull(card);
        }
        for (Player player: players)
            assertNull(player.getCardSlots()[0]);
    }

    @Test
    public void theCardsCollectedFromSlotNumbersBelongToOneAndOnlyOnePlayerInTheGame() {
        ArrayList<ICard> cardsInThirdSlotNumber = roundPhaseExecutor.collectCardsFromSlotNumber(3);
        for (ICard card: cardsInThirdSlotNumber) {
            int playerMatchCount = 0;
            for (Player player: players) {
                if (card.getPlayer() == player) playerMatchCount++;
            }
            assertEquals(1, playerMatchCount);
        }
    }

    @Test
    public void roundPhaseDoesNotCollectAnyCardsIfPlayersHaveZeroCardsInCardSlotTest() {
        for (Player player: players)
            player.resetCards();
        assertNull(roundPhaseExecutor.collectCardsFromSlotNumber(0));

    }

    @Test
    public void sortTheCardsCollectedFromACardSlotTest() {
        ArrayList<ICard> cardsInFirstSlotNumber = roundPhaseExecutor.collectCardsFromSlotNumber(0);
        roundPhaseExecutor.sortCardsByPriority(cardsInFirstSlotNumber);
        for (int i = 1; i < cardsInFirstSlotNumber.size(); i++) {
            assertTrue(cardsInFirstSlotNumber.get(i-1).priority() >= cardsInFirstSlotNumber.get(i).priority());
        }
    }

    

}
