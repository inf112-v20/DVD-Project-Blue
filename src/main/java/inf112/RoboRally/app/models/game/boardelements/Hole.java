package inf112.RoboRally.app.models.game.boardelements;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.robot.Robot;

public class Hole {

    private TiledMapTileLayer layer;

    public Hole(TiledMapTileLayer tiledMapTileLayer) {
        layer = tiledMapTileLayer;
    }

    public void effectRobot(Robot robot, int steps) {

    }
}
