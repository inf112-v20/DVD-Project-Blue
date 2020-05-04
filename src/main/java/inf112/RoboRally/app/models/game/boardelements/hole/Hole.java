package inf112.RoboRally.app.models.game.boardelements.hole;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class Hole {

    private TiledMapTileLayer layer;
    public final boolean ACTIVE;

    public Hole(TiledMapTileLayer tiledMapTileLayer) {
        if (tiledMapTileLayer != null) ACTIVE = true;
        else                           ACTIVE = false;
        layer = tiledMapTileLayer;
    }

    // bug på chopshop??
    public int effectRobot(Pos pos, Direction direction, int steps) {
        switch (direction) {
            case UP:
                return checkForHolesMovingUp(pos, steps);
            case DOWN:
                return checkForHolesMovingDown(pos, steps);
            case RIGHT:
                return checkForHolesMovingRight(pos, steps);
            case LEFT:
                return checkForHolesMovingLeft(pos, steps);
            default:
                throw new IllegalStateException("Robot has direction '"+direction+"', which is not supported");
        }
    }

    private int checkForHolesMovingLeft(Pos pos, int steps) {
        int y = pos.getY();
        for (int step = 1; step <= steps; step++) {
            pos.setX(-1);
            if (checkForHole(pos.getX(), y, HoleType.SINGLE_HOLE)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingRight(Pos pos, int steps) {
        int y = pos.getY();
        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (checkForHole(pos.getX(), y, HoleType.SINGLE_HOLE)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingDown(Pos pos, int steps) {
        int x = pos.getX();
        for (int step = 1; step <= steps; step++) {
            pos.setY(-1);
            if (checkForHole(x, pos.getY(), HoleType.SINGLE_HOLE)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingUp(Pos pos, int steps) {
        int x = pos.getX();
        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if (checkForHole(x, pos.getY(), HoleType.SINGLE_HOLE)) return step;
        }
        return steps;
    }

    public boolean standingInHole(Pos pos) {
        return checkForHole(pos.getX(), pos.getY(), HoleType.SINGLE_HOLE);
    }

    private boolean checkForHole(int x, int y, HoleType holeType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == holeType.getTileId();
    }



}
