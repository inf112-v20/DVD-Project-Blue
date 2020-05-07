package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.MapBounds;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapBoundTest {

    private MapBounds bounds;
    private Robot robot;

    @Before
    public void setUp() {
        robot = new Robot(new Pos(6, 6), Direction.RIGHT);
        bounds = new MapBounds();
    }

    @Test
    public void mapBoundsConstructorTest() {
        assertTrue(bounds.ACTIVE);
    }

    @Test
    public void testNothingHappensWhenRobotIsInsideBoundsTest() {
        bounds.effectRobotAfterCardExec(robot);
        assertFalse(robot.isDead());
    }

    @Test
    public void robotIsDeadWhenMovingOutOfLowerXBound() {
        robot.move(-5);
        bounds.effectRobotAfterCardExec(robot);
        assertTrue(robot.isDead());
    }

    @Test
    public void robotIsDeadWhenMovingOutBoundsUpperXBound() {
        robot.move(20);
        bounds.effectRobotAfterCardExec(robot);
        assertTrue(robot.isDead());
    }

    @Test
    public void robotIsDeadWhenMovingOutBoundsLowerYBound() {
        robot.rotate(Rotation.RIGHT);
        robot.move(20); // moving down
        bounds.effectRobotAfterCardExec(robot);
        assertTrue(robot.isDead());
    }

    @Test
    public void robotIsDeadWhenMovingOutBoundsUpperYBound() {
        robot.rotate(Rotation.LEFT);
        robot.move(25); // moving up
        bounds.effectRobotAfterCardExec(robot);
        assertTrue(robot.isDead());
    }

}
