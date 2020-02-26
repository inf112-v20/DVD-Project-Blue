package inf112.RoboRally.app.views;

import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class checkmateBoard {

    private Position player1StartPosition = new Position(7, 8);
    private Direction player1StartDirection = Direction.RIGHT;

    private Position player2StartPosition = new Position(7, 7);
    private Direction player2StartDirection = Direction.RIGHT;

    private final String mapName = "Checkmate";
    private final String fileName = "Boards/checkmate.tmx";

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
