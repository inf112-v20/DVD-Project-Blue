package inf112.RoboRally.app.models.game.boardelements;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.TiledMapLoader;
import inf112.RoboRally.app.models.game.boardelements.bluebelt.BlueBelt;
import inf112.RoboRally.app.models.game.boardelements.cog.Cog;
import inf112.RoboRally.app.models.game.boardelements.cornerwall.CornerWall;
import inf112.RoboRally.app.models.game.boardelements.flag.Flag;
import inf112.RoboRally.app.models.game.boardelements.hole.Hole;
import inf112.RoboRally.app.models.game.boardelements.repair.Repair;
import inf112.RoboRally.app.models.game.boardelements.twofourpusher.TwoFourPusher;
import inf112.RoboRally.app.models.game.boardelements.wall.Wall;
import inf112.RoboRally.app.models.game.boardelements.yellowbelt.YellowBelt;

public class BoardElements {

    // Elements that are supported in RoboRally
    private Wall wall;
    private Hole hole;
    private MapBounds mapBounds;
    private CornerWall cornerWall;
    private TwoFourPusher pusher;
    private BlueBelt blueBelt;
    private YellowBelt yellowBelt;
    private Cog cog;
    private Flag flag;
    private Repair repair;
    private LaserBeam laserBeam;

    IElement[] elementsThatEffectRobot;

    public BoardElements(TiledMapLoader tiledMapLoader) {
        // elements that effect robot after cards
        mapBounds = new MapBounds();
        pusher = new TwoFourPusher( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("pusher") );
        laserBeam = new LaserBeam( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("laserBeam") );
        repair = new Repair( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("repair") );
        flag = new Flag( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("flag") );
        cog = new Cog( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("cog") );
        blueBelt = new BlueBelt( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("blueArrow") );
        yellowBelt = new YellowBelt( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("yellowArrow") );
        wall = new Wall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("wall") );
        hole = new Hole( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("hole") );
        cornerWall = new CornerWall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("doubleWall") );
        elementsThatEffectRobot = new IElement[10];
        elementsThatEffectRobot[0] = hole;
        elementsThatEffectRobot[1] = mapBounds;
        elementsThatEffectRobot[2] = blueBelt;
        elementsThatEffectRobot[3] = blueBelt;
        elementsThatEffectRobot[4] = yellowBelt;
        elementsThatEffectRobot[5] = pusher;
        elementsThatEffectRobot[6] = cog;
        elementsThatEffectRobot[7] = laserBeam;
        elementsThatEffectRobot[8] = flag;
        elementsThatEffectRobot[9] = repair;

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


    public IElement[] boardEffects() {
        return elementsThatEffectRobot;
    }

    public MapBounds getMapBounds() {
        return mapBounds;
    }
}
