package inf112.RoboRally.app.views;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;

public class MapController {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapTileLayer wallLayer;

    //Maps
    public ClassicBoard classicBoard = new ClassicBoard();
    private CheckmateBoard checkmateBoard = new CheckmateBoard();

    public MapController() {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(classicBoard.getFileName());
    }

    public TiledMap getMap () {
        return map;
    }

    public Position getStartPos () {
        return classicBoard.getPlayer1StartPosition();
    }

    public Direction getStartDirection () {
        return classicBoard.getPlayer1StartDirection();
    }

}
