package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.Robot.Robot;
/*
Card to move robot forward.
 */
public class ForwardCard implements ICard {

    private int priority;
    private final int STEPS_TO_MOVE;
    private final String FILENAME;

    public ForwardCard(int stepsToMove) {
        this.STEPS_TO_MOVE = stepsToMove;
        FILENAME = "Move"+stepsToMove+".png";
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String getFileName() {
        return FILENAME;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.move(STEPS_TO_MOVE);
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
