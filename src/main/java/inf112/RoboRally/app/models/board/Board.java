package inf112.RoboRally.app.models.board;

import inf112.RoboRally.app.models.cards.Rotation;

import java.util.Optional;

public class Board {
    private Robot[] robots;
    private int width;
    private int height;
    // walls
    // lasers
    // other pieces

    public Board(int width, int height, int numRobots) {
        this.width = width;
        this.height = height;
        this.robots = new Robot[numRobots];
    }

    // Place robot on board.
    // @throws If the robot already exists on the board.
    // @throws If position is out of bounds.
    public void placeRobot(int robotId, Position position, Direction facingDirection) {}

    public Robot getRobot(int robotId) {
        return robots[robotId];
    }

    // Move robot (forward or backward).
    // @throws If the robot does not exist on the board.
    public void moveRobot(int robotId, boolean backward) {}

    // Rotate robot
    // @throws If the robot does not exist on the board.
    public void rotateRobot(int robotId, Rotation rotation) {}

    // Fire laser
    // @returns playerId of player hit, if any.
    public Optional<Integer> fireLaser(int laserId) {
        return Optional.empty();
    }
}