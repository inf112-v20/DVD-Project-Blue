package inf112.RoboRally.app.models.game.boardelements.yellowbelt;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class YellowBelt implements IElement {

    private TiledMapTileLayer layer;
    private final Boolean ACTIVE;

    public YellowBelt(TiledMapTileLayer layer) {
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

        if (checkYellowBeltType(x, y, YellowBeltType.PUSH_DOWN)) {
            robot.moveOneStepInDirection(Direction.DOWN);

        } else if (checkYellowBeltType(x, y, YellowBeltType.PUSH_UP)) {
            robot.moveOneStepInDirection(Direction.UP);

        } else if (checkYellowBeltType(x, y, YellowBeltType.PUSH_LEFT)) {
            robot.moveOneStepInDirection(Direction.LEFT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.PUSH_RIGHT)) {
            robot.moveOneStepInDirection(Direction.RIGHT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_LEFT_TO_LEFT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.LEFT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_LEFT_TO_RIGHT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.RIGHT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_LEFT_TO_UP)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.UP);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_LEFT_TO_DOWN)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.DOWN);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_RIGHT_TO_RIGHT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.RIGHT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_RIGHT_TO_LEFT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.LEFT);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_RIGHT_TO_UP)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.UP);

        } else if (checkYellowBeltType(x, y, YellowBeltType.ROTATE_RIGHT_TO_DOWN)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    private boolean checkYellowBeltType(int x, int y, YellowBeltType yellowBelt) {
        return ACTIVE && layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == yellowBelt.getTileId();
    }
}
