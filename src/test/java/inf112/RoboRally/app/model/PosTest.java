package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PosTest {

    private Pos pos;

    @Before
    public void setup() {
        pos = new Pos(8,5);
    }

    @Test
    public void positionConstructorTest() {
        assertEquals(8, pos.getX());
        assertEquals(5, pos.getY());
    }

    @Test
    public void movingAlongXAxisTest() {
        pos.updateX(2);
        assertEquals(10, pos.getX());
        pos.updateX(-4);
        assertEquals(6, pos.getX());
    }

    @Test
    public void movingAlongYAxisTest() {
        pos.updateY(5);
        assertEquals(10, pos.getY());
        pos.updateY(-1);
        assertEquals(9, pos.getY());
    }

    @Test
    public void movingAlongBothAxis() {
        pos.updateY(3);
        pos.updateX(1);
        assertEquals(9, pos.getX());
        assertEquals(8, pos.getY());
    }

    @Test
    public void movingToNegativeXAndYValue() {
        pos.updateY(-20);
        pos.updateX(-10);
        assertEquals(-15, pos.getY());
        assertEquals(-2, pos.getX());
    }

    @Test
    public void randomMovementSimulationTest() {
        Random randomX = new Random();
        Random randomY = new Random();
        for (int i = 0; i < 1000; i++) {
            int x = randomX.nextInt(1000);
            int y = randomY.nextInt(1000);
            int prevX = pos.getX();
            int prevY = pos.getY();
            pos.updateX(x);
            pos.updateY(y);
            assertEquals(prevX+x, pos.getX());
            assertEquals(prevY+y, pos.getY());
        }
    }


    @Test
    public void positionResetToInitialValues() {
        // test that position remembers values initialized with and can be reset
        pos.updateX(10);
        pos.updateY(-3);
        assertEquals(18, pos.getX());
        assertEquals(2, pos.getY());
        pos.restart();
        assertEquals(8, pos.getX());
        assertEquals(5, pos.getY());
    }

    @Test
    public void positionResetValueCanBeChanged() {
        pos.updateX(1000);
        pos.updateY(10000);
        assertEquals(1008, pos.getX());
        assertEquals(10005, pos.getY());
        pos.restart();
        assertEquals(8, pos.getX());
        assertEquals(5, pos.getY());
        pos.setNewRestartPos(17, -88);
        pos.updateX(1);
        pos.updateY(3);
        assertEquals(9, pos.getX());
        assertEquals(8, pos.getY());
        pos.restart();
        assertEquals(17, pos.getX());
        assertEquals(-88, pos.getY());

    }

}
