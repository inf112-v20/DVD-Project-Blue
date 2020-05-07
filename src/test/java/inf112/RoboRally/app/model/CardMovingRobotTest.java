package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.*;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardMovingRobotTest {

    private Player player;
    private ICard threeStepForward;
    private ICard oneStepForward;
    private ICard twoStepForward;
    private ICard reverseCard;
    private ICard rotateLeft;
    private ICard rotateRight;
    private ICard uTurn;

    @Before
    public void setup() {
        player = new Player(0, new Pos(15, 15), Direction.RIGHT);
        threeStepForward = new ForwardCard(3, 1900);
        threeStepForward.setPlayer(player);
        oneStepForward = new ForwardCard(1, 1000);
        oneStepForward.setPlayer(player);
        twoStepForward = new ForwardCard(2, 1200);
        twoStepForward.setPlayer(player);
        reverseCard = new ReverseCard(650);
        reverseCard.setPlayer(player);
        rotateLeft = new RotateCard(Rotation.LEFT, 900);
        rotateLeft.setPlayer(player);
        rotateRight = new RotateCard(Rotation.RIGHT, 1450);
        rotateRight.setPlayer(player);
        uTurn = new RotateCard(Rotation.UTURN, 200);
        uTurn.setPlayer(player);
    }


    @Test
    public void forwardThreeCardMovesRobotThreeSteps() {
        assertEquals(15, player.robot().pos().getX());
        assertEquals(Direction.RIGHT, player.robot().direction());
        threeStepForward.moveRobot();
        assertEquals(18, player.robot().pos().getX());
    }

    @Test
    public void forwardTwoCardMovesRobotTwoSteps() {
        twoStepForward.moveRobot();
        assertEquals(17, player.robot().pos().getX());
    }

    @Test
    public void oneStepForWardCardMovesRobotOneStepForward() {
        oneStepForward.moveRobot();
        assertEquals(16, player.robot().pos().getX());
    }

    @Test
    public void moveBackCardMovesRobotOneStepBack() {
        reverseCard.moveRobot();
        assertEquals(14, player.robot().pos().getX());
    }

    @Test
    public void robotIsMovedByMultipleCards() {
        threeStepForward.moveRobot();
        twoStepForward.moveRobot();
        twoStepForward.moveRobot();
        assertEquals(22, player.robot().pos().getX());
    }

    @Test
    public void robotIsMovedBackMultipleTimes() {
        reverseCard.moveRobot();
        reverseCard.moveRobot();
        assertEquals(13, player.robot().pos().getX());
    }

    @Test
    public void robotIsRotatedLeft() {
        assertEquals(Direction.RIGHT, player.robot().direction());
        rotateLeft.moveRobot();
        assertEquals(Direction.UP, player.robot().direction());
    }

    @Test
    public void robotIsRotatedRight() {
        rotateRight.moveRobot();
        assertEquals(Direction.DOWN, player.robot().direction());
    }

    @Test
    public void robotIsTurnedAround() {
        uTurn.moveRobot();
        assertEquals(Direction.LEFT, player.robot().direction());
    }

    @Test
    public void robotIsBothRotatedAndMovedInDirections() {


        Robot robot = player.robot();
        Pos robotPos = robot.pos();
        uTurn.moveRobot();
        assertEquals(Direction.LEFT, robot.direction());
        threeStepForward.moveRobot();
        assertEquals(12, robotPos.getX());
        assertEquals(15, robotPos.getY());
        uTurn.moveRobot();
        reverseCard.moveRobot();
        assertEquals(11, robotPos.getX());
        assertEquals(15, robotPos.getY());
        rotateLeft.moveRobot();
        twoStepForward.moveRobot();
        assertEquals(11, robotPos.getX());
        assertEquals(17, robotPos.getY());
        rotateRight.moveRobot();
        oneStepForward.moveRobot();
        assertEquals(12, robotPos.getX());
        assertEquals(17, robotPos.getY());

        
    }


}