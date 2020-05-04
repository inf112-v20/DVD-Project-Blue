package inf112.RoboRally.app.models.game.boardelements.cornerwall;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class CornerWall {

    TiledMapTileLayer layer;

    public CornerWall(TiledMapTileLayer layer) {
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
                if (checkForCornerWall(x, y, CornerWallType.BOTTOMRIGHT) || checkForCornerWall(x, y, CornerWallType.BOTTOMLEFT)) return 0;
                else if (checkForCornerWall(x, y-1, CornerWallType.TOPRIGHT) || checkForCornerWall(x, y-1, CornerWallType.TOPLEFT)) return 0;
            case DOWN:
                if (checkForCornerWall(x, y, CornerWallType.TOPRIGHT) || checkForCornerWall(x, y, CornerWallType.TOPLEFT)) return 0;
                else if (checkForCornerWall(x, y+1, CornerWallType.BOTTOMRIGHT) || checkForCornerWall(x, y+1, CornerWallType.BOTTOMLEFT)) return 0;
            case RIGHT:
                if (checkForCornerWall(x, y, CornerWallType.TOPLEFT) || checkForCornerWall(x, y, CornerWallType.BOTTOMLEFT)) return 0;
                else if (checkForCornerWall(x-1, y, CornerWallType.TOPRIGHT) || checkForCornerWall(x-1, y, CornerWallType.BOTTOMRIGHT)) return 0;
            case LEFT:
                if (checkForCornerWall(x, y, CornerWallType.TOPRIGHT) || checkForCornerWall(x, y, CornerWallType.BOTTOMRIGHT)) return 0;
                else if (checkForCornerWall(x+1, y, CornerWallType.TOPLEFT) || checkForCornerWall(x+1, y, CornerWallType.BOTTOMLEFT)) return 0;
        }
        return steps;
    }

    private int checkForCornerWallsMovingLeft(Pos pos, int steps) {
        int y = pos.getY();

        if (checkForCornerWall(pos.getX(), y, CornerWallType.TOPLEFT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOMLEFT))
            return 0;
        else if (checkForCornerWall(pos.getX()-1, y, CornerWallType.TOPRIGHT) || checkForCornerWall(pos.getX()-1, y, CornerWallType.TOPLEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (checkForCornerWall(pos.getX(), y, CornerWallType.TOPLEFT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOMLEFT))
                return step;
            else if (checkForCornerWall(pos.getX()-1, y, CornerWallType.TOPRIGHT) || checkForCornerWall(pos.getX()-1, y, CornerWallType.BOTTOMRIGHT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingRight(Pos pos, int steps) {
        int y = pos.getY();

        if (checkForCornerWall(pos.getX(), y, CornerWallType.TOPRIGHT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOMRIGHT))
            return 0;
        else if (checkForCornerWall(pos.getX()+1, y, CornerWallType.TOPLEFT) || checkForCornerWall(pos.getX()+1, y, CornerWallType.BOTTOMLEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (checkForCornerWall(pos.getX(), y, CornerWallType.TOPRIGHT) || checkForCornerWall(pos.getX(), y, CornerWallType.BOTTOMRIGHT))
                return step;
            else if (checkForCornerWall(pos.getX()+1, y, CornerWallType.TOPLEFT) || checkForCornerWall(pos.getX()+1, y, CornerWallType.BOTTOMLEFT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingDown(Pos pos, int steps) {
        int x = pos.getX();

        if ( checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOMLEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOMRIGHT ) )
            return 0;
        else if ( checkForCornerWall(x, pos.getY()-1, CornerWallType.TOPLEFT) || checkForCornerWall(x, pos.getY()-1, CornerWallType.TOPRIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if ( checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOMLEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.BOTTOMRIGHT ) )
                return step;
            else if ( checkForCornerWall(x, pos.getY()-1, CornerWallType.TOPLEFT) || checkForCornerWall(x, pos.getY()-1, CornerWallType.TOPRIGHT) )
                return step;
        }

        return steps;
    }

    private int checkForCornerWallsMovingUp(Pos pos, int steps) {
        int x = pos.getX();

        if ( checkForCornerWall(x, pos.getY(), CornerWallType.TOPLEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.TOPRIGHT ) )
            return 0;
        else if ( checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOMLEFT) || checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOMRIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if ( checkForCornerWall(x, pos.getY(), CornerWallType.TOPLEFT) || checkForCornerWall(x, pos.getY(), CornerWallType.TOPRIGHT ) )
                return step;
            else if ( checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOMLEFT) || checkForCornerWall(x, pos.getY()+1, CornerWallType.BOTTOMRIGHT) )
                return step;
        }

        return steps;
    }


    private boolean checkForCornerWall(int x, int y, CornerWallType cornerWallType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == cornerWallType.getTileId();
    }


}
