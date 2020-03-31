package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.robot.Robot;

/*
Card to do all rotations of robots: right, left and right two times (u-turn).
 */
public class RotateCard implements ICard {

    private final int PRIORITY;
    private final Rotation ROTATION;
    private final String FILENAME;

    private Player player;

    public RotateCard(Rotation rotation, int priority) {
        this.ROTATION = rotation;
        this.PRIORITY = priority;
        if      (rotation == Rotation.RIGHT) FILENAME = "RotateRight.png";
        else if (rotation == Rotation.LEFT)  FILENAME = "RotateLeft.png";
        else                                 FILENAME = "UTurn.png";
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public void moveRobot(Robot robot) {
        System.out.println("FROM RotateCard: I am moving the robot");
        robot.rotate(ROTATION);
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
