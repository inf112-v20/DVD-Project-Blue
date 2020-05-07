package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;

public class CardMovingRobotTest {

    private Robot robot;
    private CardFactory cardFactory;

    @Before
    public void setup() {
        robot = new Robot(new Pos(5, 5), Direction.RIGHT);
    }

}
