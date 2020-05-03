package inf112.RoboRally.app.models.game.boardelements;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.TiledMapLoader;

public class BoardElements {

    // Elements that are supported in RoboRally
    private Wall wall;
    private Hole hole;

    public BoardElements(TiledMapLoader tiledMapLoader) {
        this.wall = new Wall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("wall") );
        this.hole = new Hole( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("hole") );
    }

    public Wall getWall() {
        return wall;
    }
}
