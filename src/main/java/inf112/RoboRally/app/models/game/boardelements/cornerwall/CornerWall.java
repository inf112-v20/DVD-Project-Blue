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
                if (getWallType(x, y, CornerWallType.BOTTOMRIGHT) || getWallType(x, y, CornerWallType.BOTTOMLEFT)) return 0;
                else if (getWallType(x, y-1, CornerWallType.TOPRIGHT) || getWallType(x, y-1, CornerWallType.TOPLEFT)) return 0;
            case DOWN:
                if (getWallType(x, y, CornerWallType.TOPRIGHT) || getWallType(x, y, CornerWallType.TOPLEFT)) return 0;
                else if (getWallType(x, y+1, CornerWallType.BOTTOMRIGHT) || getWallType(x, y+1, CornerWallType.BOTTOMLEFT)) return 0;
            case RIGHT:
                if (getWallType(x, y, CornerWallType.TOPLEFT) || getWallType(x, y, CornerWallType.BOTTOMLEFT)) return 0;
                else if (getWallType(x-1, y, CornerWallType.TOPRIGHT) || getWallType(x-1, y, CornerWallType.BOTTOMRIGHT)) return 0;
            case LEFT:
                if (getWallType(x, y, CornerWallType.TOPRIGHT) || getWallType(x, y, CornerWallType.BOTTOMRIGHT)) return 0;
                else if (getWallType(x+1, y, CornerWallType.TOPLEFT) || getWallType(x+1, y, CornerWallType.BOTTOMLEFT)) return 0;
        }
        return steps;
    }

    private int checkForCornerWallsMovingLeft(Pos pos, int steps) {
        int y = pos.getY();

        if (getWallType(pos.getX(), y, CornerWallType.TOPLEFT) || getWallType(pos.getX(), y, CornerWallType.BOTTOMLEFT))
            return 0;
        else if (getWallType(pos.getX()-1, y, CornerWallType.TOPRIGHT) || getWallType(pos.getX()-1, y, CornerWallType.TOPLEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (getWallType(pos.getX(), y, CornerWallType.TOPLEFT) || getWallType(pos.getX(), y, CornerWallType.BOTTOMLEFT))
                return step;
            else if (getWallType(pos.getX()-1, y, CornerWallType.TOPRIGHT) || getWallType(pos.getX()-1, y, CornerWallType.BOTTOMRIGHT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingRight(Pos pos, int steps) {
        int y = pos.getY();

        if (getWallType(pos.getX(), y, CornerWallType.TOPRIGHT) || getWallType(pos.getX(), y, CornerWallType.BOTTOMRIGHT))
            return 0;
        else if (getWallType(pos.getX()+1, y, CornerWallType.TOPLEFT) || getWallType(pos.getX()+1, y, CornerWallType.BOTTOMLEFT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setX(1);
            if (getWallType(pos.getX(), y, CornerWallType.TOPRIGHT) || getWallType(pos.getX(), y, CornerWallType.BOTTOMRIGHT))
                return step;
            else if (getWallType(pos.getX()+1, y, CornerWallType.TOPLEFT) || getWallType(pos.getX()+1, y, CornerWallType.BOTTOMLEFT) )
                return step;
        }
        return steps;
    }

    private int checkForCornerWallsMovingDown(Pos pos, int steps) {
        int x = pos.getX();

        if ( getWallType(x, pos.getY(), CornerWallType.BOTTOMLEFT) || getWallType(x, pos.getY(), CornerWallType.BOTTOMRIGHT ) )
            return 0;
        else if ( getWallType(x, pos.getY()-1, CornerWallType.TOPLEFT) || getWallType(x, pos.getY()-1, CornerWallType.TOPRIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if ( getWallType(x, pos.getY(), CornerWallType.BOTTOMLEFT) || getWallType(x, pos.getY(), CornerWallType.BOTTOMRIGHT ) )
                return step;
            else if ( getWallType(x, pos.getY()-1, CornerWallType.TOPLEFT) || getWallType(x, pos.getY()-1, CornerWallType.TOPRIGHT) )
                return step;
        }

        return steps;
    }

    private int checkForCornerWallsMovingUp(Pos pos, int steps) {
        int x = pos.getX();

        if ( getWallType(x, pos.getY(), CornerWallType.TOPLEFT) || getWallType(x, pos.getY(), CornerWallType.TOPRIGHT ) )
            return 0;
        else if ( getWallType(x, pos.getY()+1, CornerWallType.BOTTOMLEFT) || getWallType(x, pos.getY()+1, CornerWallType.BOTTOMRIGHT) )
            return 0;

        for (int step = 1; step <= steps; step++) {
            pos.setY(1);
            if ( getWallType(x, pos.getY(), CornerWallType.TOPLEFT) || getWallType(x, pos.getY(), CornerWallType.TOPRIGHT ) )
                return step;
            else if ( getWallType(x, pos.getY()+1, CornerWallType.BOTTOMLEFT) || getWallType(x, pos.getY()+1, CornerWallType.BOTTOMRIGHT) )
                return step;
        }

        return steps;
    }


    private boolean getWallType(int x, int y, CornerWallType cornerWallType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == cornerWallType.getTileId();
    }


}
