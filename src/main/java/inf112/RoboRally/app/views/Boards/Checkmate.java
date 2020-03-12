package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.Robot.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Checkmate implements IBoard {

    private final String mapName = "Checkmate";
    private final String filePath = "Boards/Checkmate.tmx";
    private final String mapImage = "Boards/Checkmate.png";


    @Override
    public int amountOfPlayersSupported() {
        return startRobotVectors.length;
    }

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

    /*
     * player starting position stored at playernumber-1
     * for example: player1's position is at 0 (1 - 1 = 0)
     */
    private Vector2[] startRobotVectors = {
            new Vector2(6, 8),
            new Vector2(6, 9),
            new Vector2(6, 11),
            new Vector2(6, 6),
            new Vector2(6, 13),
            new Vector2(6, 4),
            new Vector2(6, 14),
            new Vector2(6, 3)
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
