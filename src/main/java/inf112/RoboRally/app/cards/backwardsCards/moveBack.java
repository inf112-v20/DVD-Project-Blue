package inf112.RoboRally.app.cards.backwardsCards;

import inf112.RoboRally.app.models.board.Robot;

public class moveBack {

    private final int stepsToTake = 1;

    public void reverseRobot(Robot robot) {
        String direction = robot.getDirection();
        if (direction == "up") {
            robot.moveDown(stepsToTake);
        } else if (direction == "right") {
            robot.moveLeft(stepsToTake);
        } else if (direction == "down") {
            robot.moveUp(stepsToTake);
        } else {
            robot.moveUp(stepsToTake);
        }
    }
}
