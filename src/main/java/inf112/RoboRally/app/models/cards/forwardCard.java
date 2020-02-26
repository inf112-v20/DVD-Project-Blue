package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;
/*
Card to move robot forward.
 */
public class forwardCard extends Card {
    private final int stepsToTake;
    // filename variable for picture will be here

    public forwardCard(int priority, int stepsToTake) {
        super(priority = priority);
        this.stepsToTake = stepsToTake;
    }

    public void moveRobot(Robot robot) {
        robot.move(stepsToTake);
    }
}
