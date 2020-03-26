package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.Robot.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Checkmate extends Board {

    public final String NAME = "Checkmate";
    public final String FILE_NAME = "Checkmate";

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

    public Checkmate(String path) {
        super();
        super.setRobotStartDirections(startRobotDirections);
        super.setRobotStartVectors(startRobotVectors);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }
}