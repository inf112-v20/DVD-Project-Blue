package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.Robot.Robot;
/*
Card to move robot forward.
 */
public class ForwardCard implements ICard {

    private final int PRIORITY;
    private int STEPS_TO_MOVE;

    public ForwardCard(int priority, int stepsToMove) {
        this.PRIORITY = priority;
        this.STEPS_TO_MOVE = stepsToMove;
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.move(STEPS_TO_MOVE);
    }
}
