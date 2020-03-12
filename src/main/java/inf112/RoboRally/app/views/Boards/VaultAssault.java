package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.Robot.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class VaultAssault implements IBoard {

    private final String mapName = "Vault Assault";
    private final String filePath = "Boards/VaultAssault.tmx";
    private final String mapImage = "Boards/VaultAssault.png";

    @Override
    public int amountOfPlayersSupported() {
        return startRobotVectors.length;
    }

    @Override
    public String getMapName() {
        return mapName;
    }

    @Override
    public String getMapImg() {
        return mapImage;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public Vector2 getRobotStartingVector(int playerNumber) {
        if (playerNumber < 0 || playerNumber > startRobotVectors.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return startRobotVectors[playerNumber-1];
    }

    @Override
    public Direction getRobotStartingDirection(int playerNumber) {
        if (playerNumber < 0 || playerNumber > startRobotVectors.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return startRobotDirections[playerNumber-1];
    }


    private Vector2[] startRobotVectors = {
            new Vector2(5, 9),
            new Vector2(5, 8),
            new Vector2(6, 11),
            new Vector2(6, 6),
            new Vector2(7, 13),
            new Vector2(7, 4),
            new Vector2(8, 14),
            new Vector2(8, 3)
    };

    private Direction[] startRobotDirections = {
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT,
            Direction.RIGHT
    };

}
