package inf112.RoboRally.app.cards;

import inf112.RoboRally.app.models.board.Robot;

public class rotateCard extends Card {
    private Rotation rotation;

    public rotateCard(int priority, Rotation rotation) {
        super(priority = priority);
        this.rotation = rotation;
    }

    public void moveRobot(Robot robot) {
        if (rotation == Rotation.LEFT) {
            robot.rotateDirectionLeft();
        } else if (rotation == Rotation.RIGHT) {
            robot.rotateDirectionRight();
        } else if (rotation == Rotation.UTURN) {
            robot.uTurn();
        }
    }

}
