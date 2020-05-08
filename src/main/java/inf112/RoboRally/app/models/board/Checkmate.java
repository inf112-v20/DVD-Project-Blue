package inf112.RoboRally.app.models.board;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Checkmate extends Board {

    public final String NAME = "Checkmate";
    public final String FILE_NAME = "Checkmate";

    private Pos[] startRobotPosition = {
            new Pos(6, 9),
            new Pos(6, 8),
            new Pos(6, 11),
            new Pos(6, 6),
            new Pos(6, 13),
            new Pos(6, 4),
            new Pos(6, 14),
            new Pos(6, 3)
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
        super.setRobotStartPositions(startRobotPosition);
        super.setRobotStartDirections(startRobotDirections);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }
}
