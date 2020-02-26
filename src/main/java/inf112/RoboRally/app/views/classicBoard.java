package inf112.RoboRally.app.views;

import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;

public class classicBoard {

    private Position player1StartPosition = new Position(6, 8);
    private Direction player1StartDirection = Direction.RIGHT;

    private Position player2StartPosition = new Position(6, 7);
    private Direction player2StartDirection = Direction.RIGHT;

    private final String mapName = "Classic Board";
    private final String fileName = "Boards/classicBoard.tmx";

    public String getMapName() {
        return mapName;
    }

    public String getFileName() {
        return fileName;
    }

    public Position getPlayer1StartPosition() {
        return player1StartPosition;
    }

    public Direction getPlayer1StartDirection() {
        return player1StartDirection;
    }

    public Position getPlayer2StartPosition() {
        return player2StartPosition;
    }

    public Direction getPlayer2StartDirection() {
        return player2StartDirection;
    }
}
