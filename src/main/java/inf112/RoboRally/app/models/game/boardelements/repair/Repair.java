package inf112.RoboRally.app.models.game.boardelements.repair;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class Repair implements IElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;

    public Repair(TiledMapTileLayer layer) {
        ACTIVE = layer != null;
        this.layer = layer;
    }

    @Override
    public int effectRobotSteps(int steps) {
        return 0;
    }

    @Override
    public void effectRobotAfterCardExec(Robot robot) {
        Pos pos = robot.position();
        int x = pos.getX(), y = pos.getY();
        if (checkForRepair(x, y, RepairType.WRENCH))
            robot.repair(RepairType.WRENCH);
        else if (checkForRepair(x, y, RepairType.WRENCH_AND_HAMMER))
            robot.repair(RepairType.WRENCH_AND_HAMMER);
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    private boolean checkForRepair(int x, int y, RepairType type) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == type.getTileId();
    }
}
