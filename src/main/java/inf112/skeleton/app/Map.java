package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Map extends TiledMap {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapTileLayer wallLayer,
            flagLayer, holeLayer;
    private final static int MAP_SIZE = 12;

    public Map() {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("GameBoard/GameBoard1.tmx");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("Walls");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        holeLayer = (TiledMapTileLayer) map.getLayers().get("Hole");
        System.out.println(wallLayer.getCell(2, 0) != null);
        System.out.println(wallLayer.getCell(2, 0).getTile().getId());
        System.out.println(flagLayer.getCell(6, 8).getTile().getId());

    }

    public TiledMap getMap() {
        return map;
    }

    public TiledMapTileLayer getMapLayers(String layer) {
        return (TiledMapTileLayer) map.getLayers().get(layer);
    }

    public TiledMapTileLayer.Cell getWallLayerCell (int x, int y) {
        return wallLayer.getCell(x, y);
    }

    public TiledMapTileLayer.Cell getFlagLayerCell (int x, int y) {
        return flagLayer.getCell(x, y);
    }

    public TiledMapTileLayer.Cell getHoleLayerCell (int x, int y) {
        return holeLayer.getCell(x, y);
    }

    public TiledMapTileLayer getWallLayer() {
        return wallLayer;
    }

    public TiledMapTileLayer getFlagLayer() {
        return flagLayer;
    }

    public TiledMapTileLayer getHoleLayer() {
        return holeLayer;
    }
}
