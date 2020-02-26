package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;

public class forwardCard extends Card {
    private final int stepsToTake;
    // filename for picture

    public forwardCard(int priority, int stepsToTake) {
        super(priority = priority);
        this.stepsToTake = stepsToTake;
    }

    public void moveRobot(Robot robot) {
        robot.move(stepsToTake);
    }
}
