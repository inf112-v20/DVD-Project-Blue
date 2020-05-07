package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.robot.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEnumDirections {

    private Direction direction;

    @Before
    public void setUp() {
        direction = Direction.LEFT;
    }

    @Test
    public void testRotateLeft() {
        assertEquals(Direction.DOWN, direction.rotateLeft());
    }

    @Test
    public void testRotateRightTwoTimes() {
        assertEquals(Direction.RIGHT, direction.rotateRight().rotateRight());
    }

    @Test
    public void testCellNumberDirection() {
        assertEquals(1, direction.CellDirectionNumber());
    }

    @Test
    public void testCellDirectionNumberAfterRotation() {
        assertEquals(4, direction.rotateRight().CellDirectionNumber());
    }
}
