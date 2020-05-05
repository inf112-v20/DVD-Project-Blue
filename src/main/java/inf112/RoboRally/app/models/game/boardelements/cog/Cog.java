package inf112.RoboRally.app.models.game.boardelements.cog;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class Cog implements IElement {

    private TiledMapTileLayer layer;
    private final boolean ACTIVE;

    public Cog(TiledMapTileLayer layer) {
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
        if (checkCogType(x, y, CogType.ROTATE_RIGHT)) robot.rotate(Rotation.RIGHT);
        else if (checkCogType(x, y, CogType.ROTATE_LEFT)) robot.rotate(Rotation.LEFT);
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }

    private boolean checkCogType(int x, int y, CogType cogType) {
        return layer.getCell(x, y) != null && layer.getCell(x, y).getTile().getId() == cogType.getTileId();
    }
}
