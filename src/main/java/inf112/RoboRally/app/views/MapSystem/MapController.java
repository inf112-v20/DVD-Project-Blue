package inf112.RoboRally.app.views.MapSystem;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;
import inf112.RoboRally.app.views.Boards.VaultAssault;

public class MapController {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapTileLayer wallLayer;
    private TiledMapTileLayer.Cell wallCell;
    public boolean validmove = false;

    //Maps
    public VaultAssault classicBoard = new VaultAssault();

    public MapController(String mapPath) {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(mapPath);
        wallLayer = (TiledMapTileLayer) map.getLayers().get("wall");
        wallCell = new TiledMapTileLayer.Cell();
    }

    public boolean isCellBlocked(float x, float y) {
        TiledMapTileLayer.Cell cell = null;

        if (wallLayer.getCell((int)x, (int)y) != null) {
            validmove = true;
        }

        return validmove;
    }

    public TiledMap getMap () {
        return map;
    }

    public TiledMapTileLayer getWallLayer () {
        return wallLayer;
    }

    public TiledMapTileLayer.Cell getWallCell () {
        return wallCell;
    }

    public Position getStartPos () {
        return classicBoard.getPlayer1StartPosition();
    }

    public Direction getStartDirection () {
        return classicBoard.getPlayer1StartDirection();
    }

    public int getWidth() {
        return map.getProperties().get("width", Integer.class);
    }

    public int getHeight() {
        return map.getProperties().get("height", Integer.class);
    }

}
