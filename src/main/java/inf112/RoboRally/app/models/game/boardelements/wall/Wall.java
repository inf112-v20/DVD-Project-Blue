package inf112.RoboRally.app.models.game.boardelements.wall;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class Wall {

    private TiledMapTileLayer layer;
    public final boolean ACTIVE;

    public Wall(TiledMapTileLayer wallLayer) {
        if (wallLayer != null) ACTIVE = true;
        else                   ACTIVE = false;
        layer = wallLayer;
    }

    public int effectRobot(Pos pos, Direction direction,  int steps) {
        if (steps == -1) {
            return checkForWallsMovingBack(pos, direction, steps);
        }
        switch (direction) {
            case UP:
                return checkForWallsMovingUp(pos, steps);
            case DOWN:
                return checkForWallsMovingDown(pos, steps);
            case RIGHT:
                return checkForWallsMovingRight(pos, steps);
            case LEFT:
                return checkForWallsMovingLeft(pos, steps);
            default:
                throw new IllegalStateException("Robot has direction '"+direction+"', which is not supported");
        }


    }

    private int checkForWallsMovingBack(Pos pos, Direction direction, int steps) {
        int x = pos.getX();
        int y = pos.getY();
        switch (direction) {
            case UP:
                if (checkForWall(x, y, WallType.DOWNSIDE)) return 0;
                else if (checkForWall(x, y-1, WallType.TOPSIDE)) return 0;
                break;
            case DOWN:
                if (checkForWall(x, y, WallType.TOPSIDE)) return 0;
                else if (checkForWall(x, y+1, WallType.DOWNSIDE)) return 0;
                break;
            case RIGHT:
                if (checkForWall(x, y, WallType.LEFTSIDE)) return 0;
                else if (checkForWall(x-1, y, WallType.RIGHTSIDE)) return 0;
                break;
            case LEFT:
                if (checkForWall(x, y, WallType.RIGHTSIDE)) return 0;
                else if (checkForWall(x+1, y, WallType.LEFTSIDE)) return 0;
                break;
        }
        return steps;
    }

    private int checkForWallsMovingLeft(Pos pos, int steps) {
        int y = pos.getY();

        // zero steps because we are standing on tile with wall on left side
        // or next to tile with right side on top side
        if (checkForWall(pos.getX(), y, WallType.LEFTSIDE))            return 0;
        else if (checkForWall(pos.getX()-1, y, WallType.RIGHTSIDE))   return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(-1);
            if (checkForWall(pos.getX(), y, WallType.LEFTSIDE))                return step;
            else if (checkForWall(pos.getX() - 1, y , WallType.RIGHTSIDE))   return step;

        }
        return steps;
    }

    private int checkForWallsMovingRight(Pos pos, int steps) {
        int y = pos.getY();

        // zero steps because we are standing on tile with wall on rightside
        // or next to tile with wall on left side
        if (checkForWall(pos.getX(), y, WallType.RIGHTSIDE))            return 0;
        else if (checkForWall(pos.getX()+1, y, WallType.LEFTSIDE))   return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (checkForWall(pos.getX(), y, WallType.RIGHTSIDE)) return step;
            else if (checkForWall(pos.getX() + 1, y , WallType.LEFTSIDE)) return step;
        }
        return steps;
    }

    private int checkForWallsMovingDown(Pos pos, int steps) {
        int x = pos.getX();

        // zero steps because we are standing on tile with wall on downside
        // or under tile with wall on top side
        if (checkForWall(x, pos.getY(), WallType.DOWNSIDE))            return 0;
        else if (checkForWall(x, pos.getY()-1, WallType.TOPSIDE))   return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(-1);
            if (checkForWall(x, pos.getY(), WallType.DOWNSIDE))                return step;
            else if (checkForWall(x, pos.getY() - 1 , WallType.TOPSIDE))  return step;

        }
        return steps;
    }

    private int checkForWallsMovingUp(Pos pos, int steps) {
        int x = pos.getX();

        // zero steps because we are standing on tile with wall on topside
        // or under tile with wall on down side
        if (checkForWall(x, pos.getY(), WallType.TOPSIDE))            return 0;
        else if (checkForWall(x, pos.getY()+1, WallType.DOWNSIDE)) return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if (checkForWall(x, pos.getY(), WallType.TOPSIDE))                return step;
            else if (checkForWall(x, pos.getY() + 1 , WallType.DOWNSIDE))  return step;

        }
        return steps;
    }

    private boolean checkForWall(int x, int y, WallType wallType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == wallType.getTileId();
    }


}
