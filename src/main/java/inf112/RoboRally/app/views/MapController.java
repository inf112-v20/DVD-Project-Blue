package inf112.RoboRally.app.views;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;
import inf112.RoboRally.app.views.Boards.Checkmate;
import inf112.RoboRally.app.views.Boards.VaultAssault;

public class MapController {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapTileLayer wallLayer;

    //Maps
    public VaultAssault classicBoard = new VaultAssault();
    private Checkmate checkmateBoard = new Checkmate();

    public MapController(String mapPath) {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(mapPath);
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
