package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.ForwardCard;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Round;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundTest {

    private SinglePlayerSettingsController settings;
    private ICard moveForwardThreeCard;
    private Player[] players;
    private Round round;

    @Before
    public void setup() {

        moveForwardThreeCard = new ForwardCard(3, 1000);
        settings = new SinglePlayerSettingsController();
        settings.incrementPlayerCount();
        settings.incrementPlayerCount();
        players = new Player[settings.getPlayerCount()];
        for (int playerNumber = 0; playerNumber < settings.getPlayerCount(); playerNumber++) {
            Pos startPos = settings.getMap().getRobotStartingPos(playerNumber);
            Direction startDir = settings.getMap().getRobotStartingDirection(playerNumber);
            players[playerNumber] = new Player(playerNumber, startPos, startDir);
        }
        round = new Round(players);
    }

    @Test
    public void testRoundDealsCardsToAllPlayers() {
        for (Player player: players) {
            for (ICard card: player.getDealtCards()) {
                assertNull(card);
            }
        }
        round.dealCards();
        for (Player player: players) {
            for (ICard card: player.getDealtCards()) {
                assertNotNull(card);
            }
        }
    }

    @Test
    public void testPlayersCardChoicesIsClearedAndRobotIsResetAfterPowerDown() {
        round.dealCards(); // player gets cards
        Player player = players[0];
        player.botPlayerChooseCardsForCardSlots(); // player fills up card slots

        moveForwardThreeCard.setPlayer(player);
        assertEquals(5, player.robot().pos().getX()); // start/reset position
        moveForwardThreeCard.moveRobot();
        assertEquals(8, player.robot().pos().getX()); // player has moved away from reset position

        // bot player have made card choices
        for (ICard card: player.getCardSlots())
            assertNotNull(card);

        player.setPowerDown(true, true);
        round.activePowerDownIfPlayerAnnouncesPowerDown();
        assertEquals(5, player.robot().pos().getX()); // back to reset because of powerdown

        // all card slots are null after powerdown
        for (ICard card: player.getCardSlots())
            assertNull(card);

    }

    @Test
    public void test() {
        
    }

}
