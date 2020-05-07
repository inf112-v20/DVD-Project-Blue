package inf112.RoboRally.app.models.game.boardelements.laserbeam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class LaserBeam implements IElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;
    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/Sound/LaserHit.wav"));

    public LaserBeam(TiledMapTileLayer layer) {
        ACTIVE = layer != null;
        this.layer = layer;
    }

    @Override
    public int effectRobotSteps(int steps) {
        return 0;
    }

    @Override
    public void effectRobotAfterCardExec(Robot robot) {
        Pos pos = robot.pos();
        int x = pos.getX(), y = pos.getY();
        if (checkForLaserBeam(x, y, LaserBeamType.SINGLE_LASER_VERTICAL)) {
            robot.looseHP(1);
            sound.play();
        }
        else if (checkForLaserBeam(x, y, LaserBeamType.SINGLE_LASER_HORIZONTAL)) {
            robot.looseHP(1);
            sound.play();
        }
        else if (checkForLaserBeam(x, y, LaserBeamType.SINGLE_LASER_CROSS)) {
            robot.looseHP(2);
            sound.play();
        }
        else if (checkForLaserBeam(x, y, LaserBeamType.DOUBLE_LASER_HORIZONTAL)) {
            robot.looseHP(2);
            sound.play();
        }
        else if (checkForLaserBeam(x, y, LaserBeamType.DOUBLE_LASER_VERTICAL)) {
            robot.looseHP(2);
            sound.play();
        }
        else if (checkForLaserBeam(x, y, LaserBeamType.DOUBLE_LASER_CROSS)) {
            robot.looseHP(4);
            sound.play();
        }
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    public boolean checkForLaserBeam(int x, int y, LaserBeamType type) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == type.getTileId();
    }
}
