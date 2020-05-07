package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    private Robot robot;

    @Before
    public void setup() {
        robot = new Robot(new Pos(5, 10), Direction.RIGHT);
    }

    @Test
    public void testConstructor() {
        assertTrue(robot.pos().getX() == 5 && robot.pos().getY() == 10);
        assertSame(robot.direction(), Direction.RIGHT);
        assertFalse(robot.isPoweredDown());
        assertFalse(robot.isDead());
        assertFalse(robot.isWinner());
        assertEquals(3, robot.livesLeft());
        assertEquals(10, robot.getHP());
    }

    @Test
    public void robotLooseHpTest() {
        robot.looseHP(3);
        assertEquals(7, robot.getHP());
        robot.looseHP(6);
        assertEquals(1, robot.getHP());
    }

    @Test
    public void looseLifeAndResetHpWhenHpIsSetToZero() {
        robot.looseHP(10);
        assertEquals(2, robot.livesLeft());
        assertEquals(10, robot.getHP());
    }


    @Test
    public void testSetRobotToPoweredDownTest() {
        robot.changePowerDown(true, true);
        assertTrue(robot.isPoweredDown());
    }

    @Test
    public void robotGainsLifeAfterBeingPoweredDown() {
        robot.looseHP(10);
        assertEquals(2, robot.livesLeft());
        robot.changePowerDown(true, true);
        assertEquals(3, robot.livesLeft());
    }

    @Test
    public void testRobotDoesNotGainLifeAfterPoweringDownWithoutLoosingLifeFirst() {
        assertEquals(3, robot.livesLeft());
        robot.changePowerDown(true, true);
        assertEquals(3, robot.livesLeft());
    }


    @Test
    public void testRobotRotation() {
        assertEquals(Direction.RIGHT, robot.direction());

        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.DOWN, robot.direction());

        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.LEFT, robot.direction());

        robot.rotate(Rotation.UTURN);
        assertEquals(Direction.RIGHT, robot.direction());

    }

    @Test
    public void positionCloneTest() {
        assertNotEquals(robot.positionClone(), robot.pos());
    }


    @Test
    public void testRobotMovementAlongXAxis() {
        // robot direction is right -> meaning it can only move back and forth along x-axis if direction is unchanged
        Pos prevPos = robot.positionClone();
        robot.move(5);

        assertEquals(prevPos.getX()+5, robot.pos().getY());
        assertSame(prevPos.getY(), robot.pos().getY());

        robot.move(5);
        assertEquals(prevPos.getX()+10, robot.pos().getX());

        robot.move(-10);
        assertEquals(prevPos.getX(), robot.pos().getX());

    }



    @Test
    public void testRobotMovementAlongYAxis() {

        // robot needs to rotate first
        robot.rotate(Rotation.LEFT);
        assertEquals(Direction.UP, robot.direction());

        Pos prevPos = robot.positionClone();

        robot.move(1);
        assertEquals(prevPos.getY()+1, robot.pos().getY());

        robot.move(4);
        assertEquals(prevPos.getY()+5, robot.pos().getY());

        robot.move(100);
        assertEquals(prevPos.getY()+105, robot.pos().getY());

        robot.move(-200);
        assertEquals(prevPos.getY()-95, robot.pos().getY());

    }


    @Test
    public void robotMovementAlongBothAxisTest() {

        Pos prevPos = robot.positionClone();

        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.DOWN, robot.direction());

        robot.move(5);
        assertEquals(prevPos.getY()-5, robot.pos().getY());

        robot.rotate(Rotation.RIGHT);
        assertEquals(Direction.LEFT, robot.direction());

        robot.move(10);
        assertEquals(prevPos.getY()-5, robot.pos().getY()); // y-cord has not changed
        assertEquals(prevPos.getX()-10, robot.pos().getX());

    }


    @Test
    public void robotCanBeResetToInitialPositionTest() {

        Pos pos = robot.pos();
        assertEquals(5, pos.getX());
        assertEquals(10, pos.getY());

        robot.move(5);
        robot.rotate(Rotation.LEFT);
        robot.move(3);
        assertEquals(10, pos.getX());
        assertEquals(13, pos.getY());

        robot.reset(false);
        assertEquals(5, pos.getX());
        assertEquals(10, pos.getY());

    }


    @Test
    public void robotCanBeMovedOneStepInDirectionTest() {

        assertEquals(5, robot.pos().getX());
        // this method is called when elements such as pushers and conveyor belts push the robot
        // and pushes the robots regardless of what direction the robot is pointing towards
        robot.moveOneStepInDirection(Direction.RIGHT);
        assertEquals(6, robot.pos().getX());

        robot.moveOneStepInDirection(Direction.DOWN);
        robot.moveOneStepInDirection(Direction.DOWN);

        assertEquals(8, robot.pos().getY());

    }


    @Test
    public void robotCanCaptureFlagTest() {


    }

    @Test
    public void robotCanCaptureFlagTwoAndThree() {


    }

    @Test
    public void robotIsSetToWinnerAfterHavingCapturedFlagThree() {

    }


    @Test
    public void robotCannotCaptureFlagTwoBeforeFlagOne() {


    }

    @Test
    public void robotCannotCaptureFlagThreeBeforeFlagTwo() {

    }


    @Test
    public void robotCanGetRepaired() {



    }

    @Test
    public void robotGetsRepairedBy() {



    }


    @Test
    public void robotGetsRepairedTwoHpBySingleWrenchAndHammerRepairType() {


    }




}
