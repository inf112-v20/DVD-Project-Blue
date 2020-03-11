package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.board.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class VaultAssault implements IBoard {

    private final String mapName = "Vault Assault";
    private final String filePath = "Boards/VaultAssault.tmx";
    private final String mapImage = "Boards/VaultAssault.png";

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
        return startRobotVectors[playerNumber-1];
    }

    @Override
    public Direction getRobotStartingDirection(int playerNumber) {
        return startRobotDirections[playerNumber-1];
    }


    private Vector2[] startRobotVectors = {
            new Vector2(5, 9),
            new Vector2(5, 8),
            new Vector2(6, 7)
    };

    private Direction[] startRobotDirections = {
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT
    };

}
