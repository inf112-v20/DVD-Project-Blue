package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.game.boardelements.RobotShootOtherRobotChecker;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RobotShootsOtherRobotTest {

    private RobotShootOtherRobotChecker shootChecker;
    private Robot[] robots;

    @Before
    public void setUp() {
        shootChecker = new RobotShootOtherRobotChecker();
        robots = new Robot[2];
    }

    @Test
    public void testRobotDoNotShootEachOtherIfTheyAreNotAligned() {
        Robot robot1 = new Robot(new Pos(4, 8), Direction.LEFT);
        Robot robot2 = new Robot(new Pos(2, 10), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot did not get shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(10, robot1.getHP());

        // the second robot did not get shot by the first robot
        assertEquals(10, robot2.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(10, robot2.getHP());
    }

    @Test
    public void robotsDidNotGetShotIfRobotsAreAlignedButNotLookingAtEachOther() {
        Robot robot1 = new Robot(new Pos(4, 10), Direction.LEFT);
        Robot robot2 = new Robot(new Pos(8, 10), Direction.RIGHT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot did not get shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(10, robot1.getHP());

        // the second robot did not get shot by the first robot
        assertEquals(10, robot2.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(10, robot2.getHP());
    }


    @Test
    public void testRobotShootAlongXAxis() {
        Robot robot1 = new Robot(new Pos(4, 8), Direction.LEFT);
        Robot robot2 = new Robot(new Pos(8, 8), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot got shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(9, robot1.getHP());

    }


    @Test
    public void testRobotShootAlongYAxis() {
        Robot robot1 = new Robot(new Pos(4, 2), Direction.RIGHT);
        Robot robot2 = new Robot(new Pos(4, 8), Direction.DOWN);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot got shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(9, robot1.getHP());

    }


    @Test
    public void testRobotShootsEachOther() {
        Robot robot1 = new Robot(new Pos(10, 8), Direction.RIGHT);
        Robot robot2 = new Robot(new Pos(20, 8), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot got shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(9, robot1.getHP());

        // the second robot got shot by the first robot
        assertEquals(10, robot2.getHP());
        shootChecker.effectRobotAfterCardExec(robot2);
        assertEquals(9, robot2.getHP());
    }

    @Test
    public void testRobotDidNotShootIfTheyArePoweredDown() {
        Robot robot1 = new Robot(new Pos(10, 8), Direction.RIGHT);
        Robot robot2 = new Robot(new Pos(20, 8), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the second robot got shot by the first robot
        assertEquals(10, robot2.getHP());
        shootChecker.effectRobotAfterCardExec(robot2);
        assertEquals(9, robot2.getHP());

        robot1.changePowerDown(true, true);
        assertTrue(robot1.isPoweredDown());

        // the second robot did not get shot when first robot was powered down
        shootChecker.effectRobotAfterCardExec(robot2);
        assertEquals(9, robot2.getHP());
    }

    @Test
    public void testRobotDidGetShotEvenIfItWasPoweredDown() {
        Robot robot1 = new Robot(new Pos(10, 8), Direction.LEFT);
        Robot robot2 = new Robot(new Pos(20, 8), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // the first robot got shot by the second robot
        assertEquals(10, robot1.getHP());
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(9, robot1.getHP());

        robot1.changePowerDown(true, true);

        assertEquals(10, robot1.getHP()); // replenishes HP when powerdown announced
        shootChecker.effectRobotAfterCardExec(robot1);
        assertEquals(9, robot1.getHP());
    }

    @Test
    public void testRobotDidNotShootOtherRobotWhenRobotIsDead() {
        Robot robot1 = new Robot(new Pos(15, 1), Direction.UP);
        Robot robot2 = new Robot(new Pos(15, 10), Direction.LEFT);
        robots[0] = robot1; robots[1] = robot2;
        shootChecker.setRobots(robots);

        // robot1 shot robot2
        assertEquals(10, robot2.getHP());
        shootChecker.effectRobotAfterCardExec(robot2);
        assertEquals(9, robot2.getHP());

        // robot1 dies
        robot1.looseHP(10);
        shootChecker.effectRobotAfterCardExec(robot2);

        // robot2 did not get shot again after robot1 died
        assertEquals(9, robot2.getHP());

    }



}
