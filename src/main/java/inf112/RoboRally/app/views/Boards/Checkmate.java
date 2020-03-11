package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.board.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Checkmate implements IBoard {

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

    @Override
    public String getMapImg() {
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
