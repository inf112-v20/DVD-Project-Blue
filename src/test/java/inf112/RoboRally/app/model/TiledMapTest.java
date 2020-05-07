package inf112.RoboRally.app.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class TiledMapTest {

    private TmxMapLoader mapLoader;
    private TiledMap tiledMap;
    private TiledMapTileLayer wallLayer;

    public TiledMapTest() {
        mapLoader = new TmxMapLoader();
        tiledMap = mapLoader.load("Board/testMap.tmx");
        wallLayer = (TiledMapTileLayer) tiledMap.getLayers().get("wall");
    }

}
