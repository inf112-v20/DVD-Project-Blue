package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Robot;

/*
Card to move reverse robot.
 */
public class ReverseCard implements ICard {


    private final int STEPS_TO_MOVE = -1;
    private final String FILENAME = "MoveBack.png";
    private int priority;

    private Player player; // determining card ownership

    public ReverseCard(int priority) {
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public void moveRobot(Robot robot) {
//        System.out.println("FROM ReverseCard: I am moving the robot");
        robot.move(STEPS_TO_MOVE);
    }


    @Override
    public String getFileName() {
        return FILENAME;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
