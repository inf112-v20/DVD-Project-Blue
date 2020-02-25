package inf112.RoboRally.app.cards;

import inf112.RoboRally.app.models.board.Robot;

public class reverseCard extends Card {
    private final int stepsToTake = -1;

    public reverseCard(int priority) {
        super(priority = priority);
    }

    public void moveRobot(Robot robot) {
        robot.move(stepsToTake);
    }
}
