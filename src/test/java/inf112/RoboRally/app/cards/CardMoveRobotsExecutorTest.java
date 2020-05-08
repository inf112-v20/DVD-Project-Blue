package inf112.RoboRally.app.cards;

import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.executors.CardMoveRobotExecutor;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;

public class CardMoveRobotsExecutorTest {

    private CardMoveRobotExecutor cardMoveRobotExecutor;

    @Before
    public void setUp() {
        Player[] players = new Player[4];
        Player player1 = new Player(0, new Pos(4, 4), Direction.RIGHT);
        Player player2 = new Player(0, new Pos(4, 6), Direction.RIGHT);
        Player player3 = new Player(0, new Pos(4, 8), Direction.RIGHT);
        Player player4 = new Player(0, new Pos(4, 10), Direction.RIGHT);
        players[0] = player1; players[1] = player2; players[2] = player3; players[3] = player4;

        for (Player player: players) {
            player.getDealtCards();
            player.botPlayerChooseCardsForCardSlots();
        }

    }


}
