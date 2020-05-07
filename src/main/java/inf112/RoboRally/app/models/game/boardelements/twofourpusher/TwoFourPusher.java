package inf112.RoboRally.app.models.game.boardelements.twofourpusher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class TwoFourPusher implements IElement {

    private TiledMapTileLayer layer;
    public final boolean ACTIVE;
    private final Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/Sound/Pusher.wav"));

    public TwoFourPusher(TiledMapTileLayer layer) {
        if (layer != null) ACTIVE = true;
        else               ACTIVE = false;
        this.layer = layer;
    }

    // not used for this
    public int effectRobotSteps(int steps) {
        return -1;
    }

    @Override
    public void effectRobotAfterCardExec(Robot robot) {
        Pos pos = robot.pos();
        int x = pos.getX(); int y = pos.getY();
        if (checkForPusher(x, y, TwoFourPusherType.TWO_FOUR_PUSH_DOWN)) {
            robot.moveOneStepInDirection(Direction.DOWN);
            sound.play();
        }
        else if (checkForPusher(x, y, TwoFourPusherType.TWO_FOUR_PUSH_UP)) {
            robot.moveOneStepInDirection(Direction.UP);
            sound.play();
        }
        else if (checkForPusher(x, y, TwoFourPusherType.TWO_FOUR_PUSH_LEFT)) {
            robot.moveOneStepInDirection(Direction.LEFT);
            sound.play();
        }
        else if (checkForPusher(x, y, TwoFourPusherType.TWO_FOUR_PUSH_RIGHT)) {
            robot.moveOneStepInDirection(Direction.RIGHT);
            sound.play();
        }
    }

    private boolean checkForPusher(int x, int y, TwoFourPusherType pusherType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == pusherType.getTileId();
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        slotNumber++;
        return (ACTIVE && ( slotNumber == 2 || slotNumber == 4 ) );
    }

}
