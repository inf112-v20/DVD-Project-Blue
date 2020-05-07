package inf112.RoboRally.app.models.game.boardelements.onethreefivepusher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class OneThreeFivePusher implements IElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;
    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/Sound/Pusher.wav"));

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
        if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_DOWN)) {
            robot.moveOneStepInDirection(Direction.DOWN);
            sound.play();
        }
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_UP)) {
            robot.moveOneStepInDirection(Direction.UP);
            sound.play();
        }
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_LEFT)) {
            robot.moveOneStepInDirection(Direction.LEFT);
            sound.play();
        }
        else if (checkForPusher(x, y, OneThreeFivePusherType.PUSH_RIGHT)) {
            robot.moveOneStepInDirection(Direction.RIGHT);
            sound.play();
        };
    }

    private boolean checkForPusher(int x, int y, OneThreeFivePusherType type) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == type.getTileId();
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        slotNumber++;
        return ACTIVE && (slotNumber == 1 || slotNumber == 3 || slotNumber == 5);
    }
}
