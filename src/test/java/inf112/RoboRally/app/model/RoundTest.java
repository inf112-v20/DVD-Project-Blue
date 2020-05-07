package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Round;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RoundTest {

    private SinglePlayerSettingsController settings;
    private Player[] players;
    private Round round;

    @Before
    public void setup() {

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
    public void testPowerDownAnnouncementsEnforced() {
        
    }

}
