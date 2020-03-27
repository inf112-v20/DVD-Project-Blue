package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.robot.Robot;
/*
Card to move robot forward.
 */
public class ForwardCard implements ICard {

    private final int PRIORITY;
    private final int STEPS_TO_MOVE;
    private final String FILENAME;

    public ForwardCard(int stepsToMove, int priority) {
        this.STEPS_TO_MOVE = stepsToMove;
        this.PRIORITY = priority;
        FILENAME = "Move"+stepsToMove+".png";
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public String getFileName() {
        return FILENAME;
    }

    @Override
    public void moveRobot(Robot robot) {
        robot.move(STEPS_TO_MOVE);
    }

}
