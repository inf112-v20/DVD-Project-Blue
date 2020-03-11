package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Checkmate implements IBoard {

    private Position player1StartPosition = new Position(7, 8);
    private Direction player1StartDirection = Direction.RIGHT;

    private Position player2StartPosition = new Position(7, 7);
    private Direction player2StartDirection = Direction.RIGHT;

    private final String mapName = "Checkmate";
    private final String filePath = "Boards/Checkmate.tmx";
    private final String mapImage = "Boards/Checkmate.png";

    public String getMapName() {
        return mapName;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    public String getMapImage() {
        return mapImage;
    }

    @Override
    public Vector2 getRobotStartingVector(int playerNumber) {
        return null;
    }

    @Override
    public Direction getRobotStartingDirection(int playerNumber) {
        return null;
    }

    private Vector2[] startRobotVectors = {
            new Vector2(7, 7),
            new Vector2(7, 8),
            new Vector2(7, 10)
    };

    private Direction[] startRobotDirections = {
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT
    };
}
