package inf112.RoboRally.app.models.board;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class WhirlwindTour extends Board {

    private final String NAME = "Whirlwind Tour";
    private final String FILE_NAME = "WhirlwindTour";

    private Pos[] startRobotPositions = {
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

    public WhirlwindTour(String path) {
        super();
        super.setRobotStartPositions(startRobotPositions);
        super.setRobotStartDirections(startRobotDirections);
        super.setFilePath(path+FILE_NAME);
        super.setMapName(NAME);
    }

}
