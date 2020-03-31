package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class TiledMapLoader {

    private TiledMap map;

    public TiledMapLoader(String tiledMapFile) {
        TmxMapLoader mapLoader = new TmxMapLoader();
        map = mapLoader.load(tiledMapFile);
    }

    public TiledMap getMap() {
        return map;
    }
}
