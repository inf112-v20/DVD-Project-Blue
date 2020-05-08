package inf112.RoboRally.app.models.game.boardelements.hole;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IRegistrationPhaseElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class Hole implements IRegistrationPhaseElement {

    private TiledMapTileLayer layer;
    public final boolean ACTIVE;
    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/Sound/Dead.wav"));

    public Hole(TiledMapTileLayer tiledMapTileLayer) {
        if (tiledMapTileLayer != null) ACTIVE = true;
        else                           ACTIVE = false;
        layer = tiledMapTileLayer;
    }

    // bug på chopshop?
    public int effectRobotSteps(Pos pos, Direction direction, int steps) {
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
            pos.updateX(-1);
            if (checkForHole(pos.getX(), y, HoleType.SINGLE_HOLE)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_LEFT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_EXTENSION)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM_3)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingRight(Pos pos, int steps) {
        int y = pos.getY();
        for (int step = 1; step <= steps; step++) {
            pos.updateX(1);
            if (checkForHole(pos.getX(), y, HoleType.SINGLE_HOLE)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_LEFT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.BIG_HOLE_EXTENSION)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_TOP_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_TOP_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_LEFT_BOTTOM_3)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM_2)) return step;
            else if (checkForHole(pos.getX(), y, HoleType.HOLE_RIGHT_BOTTOM_3)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingDown(Pos pos, int steps) {
        int x = pos.getX();
        for (int step = 1; step <= steps; step++) {
            pos.updateY(-1);
            if (checkForHole(x, pos.getY(), HoleType.SINGLE_HOLE)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_LEFT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_EXTENSION)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM_3)) return step;
        }
        return steps;
    }

    private int checkForHolesMovingUp(Pos pos, int steps) {
        int x = pos.getX();
        for (int step = 1; step <= steps; step++) {
            pos.updateY(1);
            if (checkForHole(x, pos.getY(), HoleType.SINGLE_HOLE)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_LEFT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.BIG_HOLE_EXTENSION)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_TOP_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_TOP_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_LEFT_BOTTOM_3)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM_2)) return step;
            else if (checkForHole(x, pos.getY(), HoleType.HOLE_RIGHT_BOTTOM_3)) return step;
        }
        return steps;
    }


    private boolean checkForHole(int x, int y, HoleType holeType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == holeType.getTileId();
    }


    @Override
    public void effectRobotInRegistrationPhase(Robot robot) {
        Pos pos = robot.pos();
        int x = pos.getX(), y = pos.getY();
        if (checkForHole(x, y, HoleType.SINGLE_HOLE)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.BIG_HOLE_LEFT_TOP)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.BIG_HOLE_RIGHT_TOP)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.BIG_HOLE_LEFT_BOTTOM)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.BIG_HOLE_RIGHT_BOTTOM)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.BIG_HOLE_EXTENSION)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_TOP)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_TOP_2)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_TOP_3)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_TOP)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_TOP_2)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_TOP_3)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_BOTTOM)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_BOTTOM_2)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_LEFT_BOTTOM_3)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_BOTTOM)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_BOTTOM_2)) {
            robot.reset(true);
            sound.play();
        }
        else if (checkForHole(x, y, HoleType.HOLE_RIGHT_BOTTOM_3)) {
            robot.reset(true);
            sound.play();
        }
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }


}
