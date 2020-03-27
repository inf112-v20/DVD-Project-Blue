package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.*;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardMovingRobotTest {

    private Game game;
    private ICard threeStepsForward;
    private ICard oneStepForward;
    private ICard oneStepBack;
    private ICard rotateLeft;
    private ICard rotateRight;
    private ICard uTurn;
    private Robot robot;


    @Before
    public void setup() {
        game = new Game(new SinglePlayerSettingsController());
        robot = new Robot(game, 0);
        threeStepsForward = new ForwardCard(3, 0);
        oneStepForward = new ForwardCard(1, 0);
        oneStepBack = new ReverseCard(0);
        rotateLeft = new RotateCard(Rotation.LEFT, 0);
        rotateRight = new RotateCard(Rotation.RIGHT, 0);
        uTurn = new RotateCard(Rotation.UTURN, 0);
    }

    @Test
    public void testMoveOneForwardCard() {
        oneStepForward.moveRobot(robot);

        assertEquals(5, robot.getX());
        assertEquals(6, robot.getY());
    }
//
//    @Test
//    public void testMoveThreeForwardCard() {
//        threeStepsForward.moveRobot(robot);
//        assertEquals(7, robot.getX());
//        assertEquals(4, robot.getY());
//    }
//
//    @Test
//    public void testOneStepBackCard() {
//        oneStepBack.moveRobot(robot);
//        assertEquals(3, robot.getX());
//        assertEquals(4,robot.getY());
//    }
//
//    @Test
//    public void testRotateLeftCard() {
//        rotateLeft.moveRobot(robot);
//        assertEquals(Direction.UP, robot.getDirection());
//    }
//
//    @Test
//    public void testRotateRightCardTwoTimes() {
//        rotateRight.moveRobot(robot);
//        rotateRight.moveRobot(robot);
//        assertEquals(Direction.LEFT, robot.getDirection());
//    }
//
//    @Test
//    public void testUTurnCard() {
//        uTurn.moveRobot(robot);
//        assertEquals(Direction.LEFT, robot.getDirection());
//    }
//
//    @Test
//    public void testSequenceOfCards() {
//        rotateLeft.moveRobot(robot);
//        oneStepBack.moveRobot(robot);
//        assertEquals(4, robot.getX());
//        assertEquals(3, robot.getY());
//        assertEquals(Direction.UP, robot.getDirection());
//        uTurn.moveRobot(robot);
//        threeStepsForward.moveRobot(robot);
//        assertEquals(4, robot.getX());
//        assertEquals(0, robot.getY());
//        assertEquals(Direction.DOWN, robot.getDirection());
//    }
//
//    @Test
//    public void testSequenceOfCards2() {
//        rotateRight.moveRobot(robot);
//        oneStepBack.moveRobot(robot);
//        rotateRight.moveRobot(robot);
//        rotateLeft.moveRobot(robot);
//        threeStepsForward.moveRobot(robot);
//        oneStepForward.moveRobot(robot);
//        assertEquals(4, robot.getX());
//        assertEquals(1, robot.getY());
//        assertEquals(Direction.DOWN, robot.getDirection());
//    }
}
