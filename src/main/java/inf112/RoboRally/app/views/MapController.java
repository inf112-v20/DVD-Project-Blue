package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapController {

    private TmxMapLoader mapLoader;
    private TiledMap map;

    //Maps
    private ClassicBoard classicBoard = new ClassicBoard();
    private CheckmateBoard checkmateBoard = new CheckmateBoard();

    public MapController() {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(classicBoard.getFileName());
    }

    public TiledMap getMap () {
        return map;
    }

}
