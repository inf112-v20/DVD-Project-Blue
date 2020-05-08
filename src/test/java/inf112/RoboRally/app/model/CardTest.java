package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.*;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private ICard oneStepForward;
    private ICard twoStepForward;
    private ICard reverseCard;
    private ICard rotateLeft;
    private ICard rotateRight;
    private ICard uTurn;

    @Before
    public void setUp() {
        oneStepForward = new ForwardCard(1, 1000);
        twoStepForward = new ForwardCard(2, 1200);
        reverseCard = new ReverseCard(650);
        rotateLeft = new RotateCard(Rotation.LEFT, 900);
        rotateRight = new RotateCard(Rotation.RIGHT, 1450);
        uTurn = new RotateCard(Rotation.UTURN, 200);
    }

    @Test
    public void priorityTest() {
        assertEquals(1000, oneStepForward.priority());
        assertEquals(1200, twoStepForward.priority());
        assertEquals(900, rotateLeft.priority());
    }

    @Test
    public void fileNameTest() {
        assertEquals( "RotateRight.png",rotateRight.getFileName());
        assertEquals("MoveBack.png", reverseCard.getFileName());
        assertEquals("UTurn.png", uTurn.getFileName());
    }

    @Test
    public void orderingOfCardsByPriority() {
        assertTrue(rotateLeft.priority() < twoStepForward.priority());
        assertTrue(uTurn.priority() < reverseCard.priority());
        assertFalse(rotateRight.priority() < twoStepForward.priority());
    }

    @Test
    public void setPlayerOwnerShipTest() {
        Player p = new Player(0, new Pos(0, 0), Direction.RIGHT);
        oneStepForward.setPlayer(p);
        assertSame(p, oneStepForward.getPlayer());
    }

}
