package inf112.RoboRally.app.models.game.boardelements.bluebelt;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class BlueBelt implements IElement {

    TiledMapTileLayer layer;
    public final boolean ACTIVE;

    public BlueBelt(TiledMapTileLayer layer) {
        if (layer!= null) ACTIVE = true;
        else              ACTIVE = true;
        this.layer = layer;
    }

    @Override
    public int effectRobotSteps(int steps) {
        return 0;
    }

    @Override
    public void effectRobotAfterCardExec(Robot robot) {
        Pos pos = robot.position();
        int x = pos.getX(); int y = pos.getY();
        if (checkForBlueBelt(x, y, BlueBeltType.PUSH_UP)) robot.moveOneStepInDirection(Direction.UP);
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_DOWN)) robot.moveOneStepInDirection(Direction.DOWN);
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_LEFT)) robot.moveOneStepInDirection(Direction.LEFT);
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_RIGHT)) robot.moveOneStepInDirection(Direction.RIGHT);
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        // active for all slotnumbers
        return ACTIVE;
    }

    private boolean checkForBlueBelt(int x, int y, BlueBeltType blueBelt) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == blueBelt.getTileId();
    }
}
