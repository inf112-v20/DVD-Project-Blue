package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.robot.Direction;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class ChopShopChallenge extends Board {

    public final String NAME = "ChopShopChallenge";
    public final String FILE_NAME = "ChopShopChallenge";

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

    public ChopShopChallenge(String path) {
        super();
        super.setRobotStartDirections(startRobotDirections);
        super.setRobotStartVectors(startRobotVectors);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }
}
