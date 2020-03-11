package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;
/*
Card to move reverse robot.
 */
public class ReverseCard implements ICard {


    private final int STEPS_TO_MOVE = -1;
    private int PRIORITY;
    // filename variable for picture will be here

    public ReverseCard(int priority) {
        this.PRIORITY = priority;
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
