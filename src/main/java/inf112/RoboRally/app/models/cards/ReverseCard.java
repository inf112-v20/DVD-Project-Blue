package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.Robot.Robot;
/*
Card to move reverse robot.
 */
public class ReverseCard implements ICard {


    private final int STEPS_TO_MOVE = -1;
    private final String FILENAME = "MoveBack.png";
    private int priority;

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.move(STEPS_TO_MOVE);
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
