package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;
/*
Card to do all rotations of robots: right, left and right two times (uturn).
 */
public class rotateCard extends Card {
    private Rotation rotation;
    // filename variable for picture will be here

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
