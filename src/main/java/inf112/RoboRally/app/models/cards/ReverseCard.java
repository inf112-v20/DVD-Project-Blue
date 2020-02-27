package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;
/*
Card to move reverse robot.
 */
public class ReverseCard extends Card {
    private final int stepsToTake = -1;
    // filename variable for picture will be here

    public ReverseCard(int priority) {
        super(priority = priority);
    }

    public void moveRobot(Robot robot) {
        robot.move(stepsToTake);
    }
}
