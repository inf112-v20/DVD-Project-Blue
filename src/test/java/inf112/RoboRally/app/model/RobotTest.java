package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.flag.FlagType;
import inf112.RoboRally.app.models.game.boardelements.repair.RepairType;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    private Robot robot;

    @Before
    public void setUp() {
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
        assertEquals(0, robot.flagsCaptured());
        robot.touchFlag(FlagType.FIRST_FLAG);
        assertEquals(1, robot.flagsCaptured());
    }

    @Test
    public void robotCanCaptureFlagTwoAndThree() {
        robot.touchFlag(FlagType.FIRST_FLAG);
        robot.touchFlag(FlagType.SECOND_FLAG);
        assertEquals(2, robot.flagsCaptured());
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(3, robot.flagsCaptured());
    }

    @Test
    public void robotIsSetToWinnerAfterHavingCapturedFlagThree() {
        robot.touchFlag(FlagType.FIRST_FLAG);
        robot.touchFlag(FlagType.SECOND_FLAG);
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertTrue(robot.isWinner());
    }


    @Test
    public void robotCannotCaptureFlagTwoBeforeFlagOne() {
        robot.touchFlag(FlagType.SECOND_FLAG);
        assertEquals(0, robot.flagsCaptured());
    }

    @Test
    public void robotCannotCaptureFlagThreeBeforeFlagTwo() {
        robot.touchFlag(FlagType.FIRST_FLAG);
        assertEquals(1, robot.flagsCaptured());
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(1, robot.flagsCaptured());
    }

    @Test
    public void robotGetsNewResetPositionAfterVisitingFlagOne() {
        Pos pos = robot.pos();
        robot.move(1);
        assertEquals(6, pos.getX());
        assertEquals(10, pos.getY());
        robot.touchFlag(FlagType.FIRST_FLAG); // touches flag at position (6, 10) - reset position set here
        robot.move(5);
        assertEquals(11, pos.getX());
        assertEquals(10, pos.getY());
        robot.reset(false);
        // gets reset back to position where flag was touched
        assertEquals(6, pos.getX());
        assertEquals(10, pos.getY());


    }

    @Test
    public void robotGetsNewResetPositionAfterVisitingFlagTwo() {
        Pos pos = robot.pos();
        robot.move(-2);
        assertEquals(3, pos.getX());
        assertEquals(10, pos.getY());
        robot.touchFlag(FlagType.SECOND_FLAG); // touches flag at position (3, 10) - reset position set here
        robot.move(-1);
        assertEquals(2, pos.getX());
        assertEquals(10, pos.getY());
        robot.reset(false);
        // gets reset back to position where flag was touched
        assertEquals(3, pos.getX());
        assertEquals(10, pos.getY());

    }

    @Test
    public void robotGetsNewResetPositionAfterVisitingFlagThree() {
        Pos pos = robot.pos();
        robot.rotate(Rotation.LEFT);
        robot.move(10);
        assertEquals(5, pos.getX());
        assertEquals(20, pos.getY());
        robot.touchFlag(FlagType.THIRD_FLAG);
        robot.move(-5);
        assertEquals(5, pos.getX());
        assertEquals(15, pos.getY());
        robot.reset(false);
        assertEquals(5, pos.getX());
        assertEquals(20, pos.getY());

    }

    @Test
    public void robotGainsHealthWhenVisitingAllFlags() {
        robot.looseHP(5);
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(6, robot.getHP());
        robot.touchFlag(FlagType.SECOND_FLAG);
        assertEquals(7, robot.getHP());
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(8, robot.getHP());
    }


    @Test
    public void robotCannotGainMoreThanMaxHPWhenTouchingFlag() {
        assertEquals(10, robot.getHP());
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(10, robot.getHP());
        robot.touchFlag(FlagType.SECOND_FLAG);
        assertEquals(10, robot.getHP());
        robot.touchFlag(FlagType.THIRD_FLAG);
        assertEquals(10, robot.getHP());
    }


    @Test
    public void robotGainsOneHealthWhenTouchingWrenchRepairType() {
        robot.looseHP(2);
        robot.repair(RepairType.WRENCH);
        assertEquals(9, robot.getHP());
    }



    @Test
    public void robotGainsTwoHealthWhenTouchingWrenchAndHammerRepairType() {
        robot.looseHP(2);
        robot.repair(RepairType.WRENCH_AND_HAMMER);
        assertEquals(10, robot.getHP());

    }

    @Test
    public void robotGetsNewResetPositionWhenTouchingSingleWrenchRepairType() {
        robot.move(3);
        assertEquals(8, robot.pos().getX());
        assertEquals(10, robot.pos().getY());
        robot.repair(RepairType.WRENCH);
        robot.move(3);
        assertEquals(11, robot.pos().getX());
        assertEquals(10, robot.pos().getY());
        robot.reset(false);
        assertEquals(8, robot.pos().getX());
        assertEquals(10, robot.pos().getY());

    }

    @Test
    public void robotGetsNewResetPositionWhenTouchingWrenchAndHammerRepairType() {
        robot.move(-1);
        assertEquals(4, robot.pos().getX());
        assertEquals(10, robot.pos().getY());
        robot.repair(RepairType.WRENCH);
        robot.move(10);
        assertEquals(14, robot.pos().getX());
        assertEquals(10, robot.pos().getY());
        robot.reset(false);
        assertEquals(4, robot.pos().getX());
        assertEquals(10, robot.pos().getY());
    }




}
