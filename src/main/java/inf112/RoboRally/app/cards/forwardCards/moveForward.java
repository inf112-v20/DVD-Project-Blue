package inf112.RoboRally.app.cards.forwardCards;

import inf112.RoboRally.app.models.board.Robot;

public class moveForward {

    private int stepsToTake;

    public moveForward(int stepsToTake) {
        this.stepsToTake = stepsToTake;
    }

    public void moveRobotForward(Robot robot) {
        String direction = robot.getDirection();
        if (direction == "up") {
            robot.moveUp(stepsToTake);
        } else if (direction == "right") {
            robot.moveRight(stepsToTake);
        } else if (direction == "down") {
            robot.moveDown(stepsToTake);
        } else {
            robot.moveLeft(stepsToTake);
        }
    }
}
