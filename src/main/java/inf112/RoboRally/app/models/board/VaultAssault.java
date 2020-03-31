package inf112.RoboRally.app.models.board;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class VaultAssault extends Board {

    private final String NAME = "Vault Assault";
    private final String FILE_NAME = "VaultAssault";

    private Pos[] startRobotPositions = {
            new Pos(5, 9),
            new Pos(5, 8),
            new Pos(6, 11),
            new Pos(6, 6),
            new Pos(7, 13),
            new Pos(7, 4),
            new Pos(8, 14),
            new Pos(8, 3)
    };

//    private Vector2[] startRobotVectors = {
//            new Vector2(5, 9),
//            new Vector2(5, 8),
//            new Vector2(6, 11),
//            new Vector2(6, 6),
//            new Vector2(7, 13),
//            new Vector2(7, 4),
//            new Vector2(8, 14),
//            new Vector2(8, 3)
//    };

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

    public VaultAssault(String path) {
        super();
        super.setRobotStartPositions(startRobotPositions);
        super.setRobotStartDirections(startRobotDirections);
//        super.setRobotStartVectors(startRobotVectors);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }
}
