package inf112.RoboRally.app.cards.uTurn;

import inf112.RoboRally.app.models.board.Robot;

public class uTurn {

    public void turnRobotAround(Robot robot) {
        robot.rotateRight();
        robot.rotateRight();
    }
}
