package inf112.RoboRally.app.models.board;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class Tricksy extends Board {

    private final String NAME = "Tricksy";
    private final String FILE_NAME = "Tricksy";

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

    public Tricksy(String path) {
        super();
        super.setRobotStartPositions(startRobotPositions);
        super.setRobotStartDirections(startRobotDirections);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }

}
