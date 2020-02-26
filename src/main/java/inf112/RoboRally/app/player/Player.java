package inf112.RoboRally.app.player;

import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;
import inf112.RoboRally.app.models.board.Robot;

public class Player {

    private String name;
    private Robot robot;
    private playerHud hud;
    private int playerNumber;

    public Player(Position pos, Direction direction, int playerNumber) {
        robot = new Robot(pos, direction);
        this.playerNumber = playerNumber;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
