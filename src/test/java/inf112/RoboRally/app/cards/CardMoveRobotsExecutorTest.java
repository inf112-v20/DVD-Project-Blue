package inf112.RoboRally.app.cards;

import inf112.RoboRally.app.models.cards.*;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.executors.CardMoveRobotExecutor;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class CardMoveRobotsExecutorTest {

    private CardMoveRobotExecutor cardMoveRobotExecutor;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private ICard oneStepForward;
    private ICard twoStepForward;
    private ICard reverseCard;
    private ICard rotateLeft;

    @Before
    public void setUp() {

        // setting up the players
        player1 = new Player(0, new Pos(4, 4), Direction.RIGHT);
        player2 = new Player(0, new Pos(4, 6), Direction.RIGHT);
        player3 = new Player(0, new Pos(4, 8), Direction.RIGHT);
        player4 = new Player(0, new Pos(4, 10), Direction.RIGHT);


        // giving each player a card

        //player 1 is to move one step forward
        oneStepForward = new ForwardCard(1, 1000);
        oneStepForward.setPlayer(player1);


        // player2 is to move two steps forward
        twoStepForward = new ForwardCard(2, 1200);
        twoStepForward.setPlayer(player2);

        // player3 is to move one step back
        reverseCard = new ReverseCard(650);
        reverseCard.setPlayer(player3);

        // player4 is to rotate left
        rotateLeft = new RotateCard(Rotation.LEFT, 900);
        rotateLeft.setPlayer(player4);


    }

    @Test
    public void cardsGivenToTheCardMoveRobotExecutorAreExecuted() {
        ArrayList<ICard> cards = new ArrayList<>();
        cards.add(oneStepForward);
        cards.add(twoStepForward);
        cards.add(reverseCard);
        cards.add(rotateLeft);

        CountDownLatch cardExecutionLatch = new CountDownLatch(1);
        cardMoveRobotExecutor = new CardMoveRobotExecutor(cards, cardExecutionLatch);

        // player1 initial position
        assertEquals(4, player1.robot().pos().getX());
        assertEquals(4, player1.robot().pos().getY());

        // player2 initial position
        assertEquals(4, player2.robot().pos().getX());
        assertEquals(6, player2.robot().pos().getY());

        // player3 initial position
        assertEquals(4, player3.robot().pos().getX());
        assertEquals(8, player3.robot().pos().getY());

        // player4 initial direction
        assertEquals(Direction.RIGHT, player4.robot().direction());

        // execution taking place
        cardMoveRobotExecutor.executeCards();

        // assert that executor must finish before positions change

        // player1 initial position
        assertEquals(4, player1.robot().pos().getX());
        assertEquals(4, player1.robot().pos().getY());

        // player2 initial position
        assertEquals(4, player2.robot().pos().getX());
        assertEquals(6, player2.robot().pos().getY());

        // player3 initial position
        assertEquals(4, player3.robot().pos().getX());
        assertEquals(8, player3.robot().pos().getY());

        // player4 initial direction
        assertEquals(Direction.RIGHT, player4.robot().direction());

        try {
            cardExecutionLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // player1 new position
        assertEquals(5, player1.robot().pos().getX());
        assertEquals(4, player1.robot().pos().getY());

        // player2 new position
        assertEquals(6, player2.robot().pos().getX());
        assertEquals(6, player2.robot().pos().getY());

        // player3 new position
        assertEquals(3, player3.robot().pos().getX());
        assertEquals(8, player3.robot().pos().getY());

        // player4 new position
        assertEquals(Direction.UP, player4.robot().direction());

    }

    @Test
    public void testThatOnlyCardsThatAreGivenToCardMovementExecutorIsUsed() {
        ArrayList<ICard> cards = new ArrayList<>();
        cards.add(oneStepForward);
        cards.add(twoStepForward);

        CountDownLatch cardExecutionLatch = new CountDownLatch(1);
        cardMoveRobotExecutor = new CardMoveRobotExecutor(cards, cardExecutionLatch);

        // player1 initial position
        assertEquals(4, player1.robot().pos().getX());
        assertEquals(4, player1.robot().pos().getY());

        // player2 initial position
        assertEquals(4, player2.robot().pos().getX());
        assertEquals(6, player2.robot().pos().getY());

        // player3 initial position
        assertEquals(4, player3.robot().pos().getX());
        assertEquals(8, player3.robot().pos().getY());

        // player4 initial direction
        assertEquals(Direction.RIGHT, player4.robot().direction());

        // execution taking place
        cardMoveRobotExecutor.executeCards();

        try {
            cardExecutionLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // player1 new position
        assertEquals(5, player1.robot().pos().getX());
        assertEquals(4, player1.robot().pos().getY());

        // player2 new position
        assertEquals(6, player2.robot().pos().getX());
        assertEquals(6, player2.robot().pos().getY());

        // player3 still at initial position
        assertEquals(4, player3.robot().pos().getX());
        assertEquals(8, player3.robot().pos().getY());

        // player4 still looking in initial direction
        assertEquals(Direction.RIGHT, player4.robot().direction());
    }


}
