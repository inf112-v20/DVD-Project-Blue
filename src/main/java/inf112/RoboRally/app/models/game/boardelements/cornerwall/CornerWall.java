package inf112.RoboRally.app.models.game.boardelements.cornerwall;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class CornerWall {

    private TiledMapTileLayer layer;
    public final boolean ACTIVE;

    public CornerWall(TiledMapTileLayer layer) {
        if (layer != null) ACTIVE = true;
        else               ACTIVE = false;
        this.layer = layer;
    }

    public int effectRobot(Pos pos, Direction direction, int steps) {
        if (steps == -1) {
            return checkForCornerWallsMovingBack(pos, direction, steps);
        }

        switch (direction) {
            case UP:
                return checkForCornerWallsMovingUp(pos, steps);
            case DOWN:
                return checkForCornerWallsMovingDown(pos, steps);
            case RIGHT:
                return checkForCornerWallsMovingRight(pos, steps);
            case LEFT:
                return checkForCornerWallsMovingLeft(pos, steps);
            default:
                throw new IllegalStateException("Robot has direction '"+direction+"', which is not supported");
        }
    }

    private int checkForCornerWallsMovingBack(Pos pos, Direction direction, int steps) {
        int x = pos.getX();
        int y = pos.getY();
        switch (direction) {
            case UP:
                if (checkForCornerWall(x, y, CornerWallType.BOTTOM_RIGHT) || checkForCornerWall(x, y, CornerWallType.BOTTOM_LEFT)) return 0;
                else if (checkForCornerWall(x, y-1, CornerWallType.TOP_RIGHT) || checkForCornerWall(x, y-1, CornerWallType.TOP_LEFT)) return 0;
            case DOWN:
                if (checkForCornerWall(x, y, CornerWallType.TOP_RIGHT) || checkForCornerWall(x, y, CornerWallType.TOP_LEFT)) return 0;
                else if (checkForCornerWall(x, y+1, CornerWallType.BOTTOM_RIGHT) || checkForCornerWall(x, y+1, CornerWallType.BOTTOM_LEFT)) return 0;
            case RIGHT:
                if (checkForCornerWall(x, y, CornerWallType.TOP_LEFT) || checkForCornerWall(x, y, CornerWallType.BOTTOM_LEFT)) return 0;
                else if (checkForCornerWall(x-1, y, CornerWallType.TOP_RIGHT) || checkForCornerWall(x-1, y, CornerWallType.BOTTOM_RIGHT)) return 0;
            case LEFT:
                if (checkForCornerWall(x, y, CornerWallType.TOP_RIGHT) || checkForCornerWall(x, y, CornerWallType.BOTTOM_RIGHT)) return 0;
                else if (checkForCornerWall(x+1, y, CornerWallType.TOP_LEFT) || checkForCornerWall(x+1, y, CornerWallType.BOTTOM_LEFT)) return 0;
        }
        return steps;
    }

    private int checkForCornerWallsMovingLeft(Pos pos, int steps) {
        int y = pos.getY();

        if (checkForCornerWall(pos.getX(), y, CornerWallType.TOP_LEFT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOM_LEFT))
            return 0;
        else if (checkForCornerWall(pos.getX()-1, y, CornerWallType.TOP_RIGHT) || checkForCornerWall(pos.getX()-1, y, CornerWallType.TOP_LEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.updateX(1);
            if (checkForCornerWall(pos.getX(), y, CornerWallType.TOP_LEFT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOM_LEFT))
                return step;
            else if (checkForCornerWall(pos.getX()-1, y, CornerWallType.TOP_RIGHT) || checkForCornerWall(pos.getX()-1, y, CornerWallType.BOTTOM_RIGHT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingRight(Pos pos, int steps) {
        int y = pos.getY();

        if (checkForCornerWall(pos.getX(), y, CornerWallType.TOP_RIGHT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOM_RIGHT))
            return 0;
        else if (checkForCornerWall(pos.getX()+1, y, CornerWallType.TOP_LEFT) || checkForCornerWall(pos.getX()+1, y, CornerWallType.BOTTOM_LEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.updateX(1);
            if (checkForCornerWall(pos.getX(), y, CornerWallType.TOP_RIGHT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOM_RIGHT))
                return step;
            else if (checkForCornerWall(pos.getX()+1, y, CornerWallType.TOP_LEFT) || checkForCornerWall(pos.getX()+1, y, CornerWallType.BOTTOM_LEFT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingDown(Pos pos, int steps) {
        int x = pos.getX();

        if ( checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOM_LEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOM_RIGHT) )
            return 0;
        else if ( checkForCornerWall(x, pos.getY()-1, CornerWallType.TOP_LEFT) || checkForCornerWall(x, pos.getY()-1, CornerWallType.TOP_RIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.updateY(1);
            if ( checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOM_LEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOM_RIGHT) )
                return step;
            else if ( checkForCornerWall(x, pos.getY()-1, CornerWallType.TOP_LEFT) || checkForCornerWall(x, pos.getY()-1, CornerWallType.TOP_RIGHT) )
                return step;
        }

        return steps;
    }

    private int checkForCornerWallsMovingUp(Pos pos, int steps) {
        int x = pos.getX();

        if ( checkForCornerWall(x, pos.getY(), CornerWallType.TOP_LEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.TOP_RIGHT) )
            return 0;
        else if ( checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOM_LEFT) || checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOM_RIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.updateY(1);
            if ( checkForCornerWall(x, pos.getY(), CornerWallType.TOP_LEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.TOP_RIGHT) )
                return step;
            else if ( checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOM_LEFT) || checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOM_RIGHT) )
                return step;
        }

        return steps;
    }


    private boolean checkForCornerWall(int x, int y, CornerWallType cornerWallType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == cornerWallType.getTileId();
    }


}
