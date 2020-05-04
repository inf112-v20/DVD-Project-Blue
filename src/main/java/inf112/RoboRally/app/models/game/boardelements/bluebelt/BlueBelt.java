package inf112.RoboRally.app.models.game.boardelements.bluebelt;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class BlueBelt implements IElement {

    TiledMapTileLayer layer;
    public final boolean ACTIVE;

    public BlueBelt(TiledMapTileLayer layer) {
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
        if (checkForBlueBelt(x,y, BlueBeltType.PUSH_UP) && checkForBlueBelt(x, y+1, BlueBeltType.UP_AND_DOWN_TO_RIGHT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.UP);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_UP)) robot.moveOneStepInDirection(Direction.UP);
        else if (checkForBlueBelt(x,y, BlueBeltType.PUSH_DOWN) && checkForBlueBelt(x, y-1, BlueBeltType.UP_AND_DOWN_TO_RIGHT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y-1, BlueBeltType.RIGHT_FROM_ABOVE) && checkForBlueBelt(x, y, BlueBeltType.PUSH_DOWN)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_DOWN)) robot.moveOneStepInDirection(Direction.DOWN);
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_LEFT) && checkForBlueBelt(x-1, y, BlueBeltType.UP_FROM_LEFT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.LEFT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_LEFT)) robot.moveOneStepInDirection(Direction.LEFT);
        else if (checkForBlueBelt(x+1, y, BlueBeltType.UP_FROM_RIGHT) && checkForBlueBelt(x, y, BlueBeltType.PUSH_RIGHT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.RIGHT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_RIGHT) && checkForBlueBelt(x+1, y, BlueBeltType.DOWN_FROM_RIGHT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.PUSH_RIGHT)) robot.moveOneStepInDirection(Direction.RIGHT);
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_RIGHT_TO_RIGHT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.RIGHT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_RIGHT_TO_DOWN)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_RIGHT_TO_LEFT)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.LEFT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_RIGHT_TO_UP)) {
            robot.rotate(Rotation.RIGHT);
            robot.moveOneStepInDirection(Direction.UP);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_LEFT_TO_LEFT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.LEFT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATING_LEFT_TO_DOWN)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATING_LEFT_TO_RIGHT)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.RIGHT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.ROTATE_LEFT_TO_UP)) {
            robot.rotate(Rotation.LEFT);
            robot.moveOneStepInDirection(Direction.UP);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.UP_FROM_RIGHT)) {
            robot.moveOneStepInDirection(Direction.UP);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.UP_AND_DOWN_TO_RIGHT)) {
            robot.moveOneStepInDirection(Direction.RIGHT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.RIGHT_FROM_ABOVE)) {
            robot.moveOneStepInDirection(Direction.RIGHT);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.DOWN_FROM_RIGHT)) {
            robot.moveOneStepInDirection(Direction.DOWN);
        }
        else if (checkForBlueBelt(x, y, BlueBeltType.UP_FROM_LEFT)) {
            robot.moveOneStepInDirection(Direction.UP);
        }
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
