package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import org.lwjgl.Sys;

import java.awt.*;

public class Map extends TiledMap {

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapTileLayer wallLayer,
            flagLayer;
    private final static int MAP_SIZE = 12;

    public Map() {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("GameBoard/GameBoard1.tmx");
        wallLayer = (TiledMapTileLayer) map.getLayers().get("Walls");
        flagLayer = (TiledMapTileLayer) map.getLayers().get("Flag");
        System.out.println(wallLayer.getCell(2, 0) != null);
        System.out.println(wallLayer.getCell(2, 0).getTile().getId());
        System.out.println(flagLayer.getCell(6, 8).getTile().getId());

    }

    public TiledMap getMap() {
        return map;
    }

//    private void getTiles(String name) {
//        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(name);
//        for (int y = 0; y < MAP_SIZE; y++) {
//            for (int x = 0; x < MAP_SIZE; x++) {
//                TiledMapTileLayer.Cell cell = layer.getCell(x, y);
//            }
//        }
//    }
//
    public TiledMapTileLayer getMapLayers(String layer) {
        return (TiledMapTileLayer) map.getLayers().get(layer);
    }

    public TiledMapTileLayer.Cell getLayerCell (int x, int y) {
        return wallLayer.getCell(x, y);
    }

    public TiledMapTileLayer getWallLayer() {
        return wallLayer;
    }
}
