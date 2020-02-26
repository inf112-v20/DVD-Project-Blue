package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;
import inf112.RoboRally.app.models.board.Robot;
import inf112.RoboRally.app.models.cards.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CardMovingRobotTest {

    private Card threeStepsForward;
    private Card oneStepForward;
    private Card oneStepBack;
    private Card rotateLeft;
    private Card rotateRight;
    private Card uTurn;
    private Robot robot;

    @Before
    public void setup() {
        robot = new Robot(new Position(4,4), Direction.RIGHT);
        threeStepsForward = new forwardCard(1000, 3);
        oneStepForward = new forwardCard(900, 1);
        oneStepBack = new reverseCard(800);
        rotateLeft = new rotateCard(1300, Rotation.LEFT);
        rotateRight = new rotateCard(750, Rotation.RIGHT);
        uTurn = new rotateCard(500, Rotation.UTURN);
    }

    @Test
    public void testMoveOneForwardCard() {
        oneStepForward.moveRobot(robot);
        assertEquals(5, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    public void testMoveThreeForwardCard() {
        threeStepsForward.moveRobot(robot);
        assertEquals(7, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    public void testOneStepBackCard() {
        oneStepBack.moveRobot(robot);
        assertEquals(3, robot.getX());
        assertEquals(4,robot.getY());
    }

    @Test
    public void testRotateLeftCard() {
        rotateLeft.moveRobot(robot);
        assertEquals(Direction.UP, robot.getDirection());
    }

    @Test
    public void testRotateRightCardTwoTimes() {
        rotateRight.moveRobot(robot);
        rotateRight.moveRobot(robot);
        assertEquals(Direction.LEFT, robot.getDirection());
    }

    @Test
    public void testUTurnCard() {
        uTurn.moveRobot(robot);
        assertEquals(Direction.LEFT, robot.getDirection());
    }

    @Test
    public void testSequenceOfCards() {
        rotateLeft.moveRobot(robot);
        oneStepBack.moveRobot(robot);
        assertEquals(4, robot.getX());
        assertEquals(3, robot.getY());
        assertEquals(Direction.UP, robot.getDirection());
        uTurn.moveRobot(robot);
        threeStepsForward.moveRobot(robot);
        assertEquals(4, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Direction.DOWN, robot.getDirection());
    }

    @Test
    public void testSequenceOfCards2() {
        rotateRight.moveRobot(robot);
        oneStepBack.moveRobot(robot);
        rotateRight.moveRobot(robot);
        rotateLeft.moveRobot(robot);
        threeStepsForward.moveRobot(robot);
        oneStepForward.moveRobot(robot);
        assertEquals(4, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.DOWN, robot.getDirection());
    }
}
