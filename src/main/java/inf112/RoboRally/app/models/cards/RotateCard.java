package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;

/*
Card to do all rotations of robots: right, left and right two times (uturn).
 */
public class RotateCard implements ICard {

    private final int PRIORITY;
    private final Rotation ROTATION;

    public RotateCard(int priority, Rotation rotation) {
        this.PRIORITY = priority;
        this.ROTATION = rotation;
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.rotate(ROTATION);
    }
}
