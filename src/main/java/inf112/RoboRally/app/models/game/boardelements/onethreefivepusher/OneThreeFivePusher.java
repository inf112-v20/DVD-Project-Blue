package inf112.RoboRally.app.models.game.boardelements.onethreefivepusher;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class OneThreeFivePusher implements IElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;

    public OneThreeFivePusher(TiledMapTileLayer layer) {
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
        if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_DOWN))
            robot.moveOneStepInDirection(Direction.DOWN);
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_UP))
            robot.moveOneStepInDirection(Direction.UP);
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_LEFT))
            robot.moveOneStepInDirection(Direction.LEFT);
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_RIGHT));
    }

    private boolean checkForPusher(int x, int y, OneThreeFivePusherType type) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == type.getTileId();
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE && (slotNumber == 1 || slotNumber == 3 || slotNumber == 5);
    }
}
