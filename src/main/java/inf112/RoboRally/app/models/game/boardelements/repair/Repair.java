package inf112.RoboRally.app.models.game.boardelements.repair;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IRegistrationPhaseElement;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class Repair implements IRegistrationPhaseElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;
    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/Sound/Repair.wav"));

    public Repair(TiledMapTileLayer layer) {
        ACTIVE = layer != null;
        this.layer = layer;
    }


    @Override
    public void effectRobotInRegistrationPhase(Robot robot) {
        Pos pos = robot.pos();
        int x = pos.getX(), y = pos.getY();

        if (!robot.isDead()) {
            if (checkForRepair(x, y, RepairType.WRENCH)) {
                robot.repair(RepairType.WRENCH);
                sound.play();
            }
            else if (checkForRepair(x, y, RepairType.WRENCH_AND_HAMMER)) {
                robot.repair(RepairType.WRENCH_AND_HAMMER);
                sound.play();
            }
        }

    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    private boolean checkForRepair(int x, int y, RepairType type) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == type.getTileId();
    }
}
