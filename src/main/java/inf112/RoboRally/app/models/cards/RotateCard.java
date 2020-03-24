package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.Robot.Robot;

/*
Card to do all rotations of robots: right, left and right two times (uturn).
 */
public class RotateCard implements ICard {

    private int priority;
    private final Rotation ROTATION;
    private final String FILENAME;

    public RotateCard(Rotation rotation) {
        this.ROTATION = rotation;
        if      (rotation == Rotation.RIGHT) FILENAME = "RotateRight.png";
        else if (rotation == Rotation.LEFT)  FILENAME = "RotateLeft.png";
        else                                 FILENAME = "U-Turn.png";
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.rotate(ROTATION);
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String getFileName() {
        return FILENAME;
    }
}
