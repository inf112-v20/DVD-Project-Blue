package inf112.RoboRally.app.models.game.boardelements.flag;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IRegistrationPhaseElement;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class Flag implements IRegistrationPhaseElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;

    public Flag(TiledMapTileLayer layer) {
        ACTIVE = layer != null;
        this.layer = layer;
    }


    @Override
    public void effectRobotInRegistrationPhase(Robot robot) {
        Pos pos = robot.pos();
        int x = pos.getX(), y = pos.getY();
        if (checkFlagType(x, y, FlagType.FIRST_FLAG))
            robot.touchFlag(FlagType.FIRST_FLAG);
        else if (checkFlagType(x, y, FlagType.SECOND_FLAG))
            robot.touchFlag(FlagType.SECOND_FLAG);
        else if (checkFlagType(x, y, FlagType.THIRD_FLAG)) {
            robot.touchFlag(FlagType.THIRD_FLAG);
        }
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    private boolean checkFlagType(int x, int y, FlagType flagType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == flagType.getTileId();
    }
}
