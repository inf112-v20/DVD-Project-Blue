package inf112.RoboRally.app.models.game.boardelements;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.TiledMapLoader;
import inf112.RoboRally.app.models.game.boardelements.cornerwall.CornerWall;
import inf112.RoboRally.app.models.game.boardelements.hole.Hole;
import inf112.RoboRally.app.models.game.boardelements.twofourpusher.TwoFourPusher;
import inf112.RoboRally.app.models.game.boardelements.wall.Wall;

public class BoardElements {

    // Elements that are supported in RoboRally
    private Wall wall;
    private Hole hole;
    private CornerWall cornerWall;
//    private TwoFourPusher pusher;

    IElement[] elementsThatMoveRobot;

    public BoardElements(TiledMapLoader tiledMapLoader) {
        elementsThatMoveRobot = new IElement[1];
        elementsThatMoveRobot[0] = new TwoFourPusher( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("pusher") );
        wall = new Wall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("wall") );
        hole = new Hole( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("hole") );
        cornerWall = new CornerWall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("doubleWall") );
    }

    public Wall getWall() {
        return wall;
    }

    public CornerWall getCornerWall() {
        return cornerWall;
    }

    public Hole getHole() {
        return hole;
    }

//    public TwoFourPusher getPusher() {
//        return pusher;
//    }

    public IElement[] boardEffects() {
        return elementsThatMoveRobot;
    }
}
