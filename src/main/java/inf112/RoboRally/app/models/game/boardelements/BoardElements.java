package inf112.RoboRally.app.models.game.boardelements;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.RoboRally.app.models.game.TiledMapLoader;
import inf112.RoboRally.app.models.game.boardelements.bluebelt.BlueBelt;
import inf112.RoboRally.app.models.game.boardelements.cog.Cog;
import inf112.RoboRally.app.models.game.boardelements.cornerwall.CornerWall;
import inf112.RoboRally.app.models.game.boardelements.flag.Flag;
import inf112.RoboRally.app.models.game.boardelements.hole.Hole;
import inf112.RoboRally.app.models.game.boardelements.twofourpusher.TwoFourPusher;
import inf112.RoboRally.app.models.game.boardelements.wall.Wall;

public class BoardElements {

    // Elements that are supported in RoboRally
    private Wall wall;
    private Hole hole;
    private CornerWall cornerWall;
    private TwoFourPusher pusher;
    private BlueBelt blueBelt;
    private YellowBelt yellowBelt;
    private Cog cog;
    private Flag flag;

    IElement[] elementsThatEffectRobot;

    public BoardElements(TiledMapLoader tiledMapLoader) {
        // elements that effect robot after cards
        pusher = new TwoFourPusher( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("pusher") );
        flag = new Flag( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("flag") );
        cog = new Cog( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("cog") );
        blueBelt = new BlueBelt( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("blueArrow") );
        yellowBelt = new YellowBelt( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("yellowArrow") );
        wall = new Wall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("wall") );
        hole = new Hole( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("hole") );
        cornerWall = new CornerWall( (TiledMapTileLayer) tiledMapLoader.getMap().getLayers().get("doubleWall") );
        elementsThatEffectRobot = new IElement[6];
        elementsThatEffectRobot[0] = blueBelt;
        elementsThatEffectRobot[1] = blueBelt;
        elementsThatEffectRobot[2] = yellowBelt;
        elementsThatEffectRobot[3] = pusher;
        elementsThatEffectRobot[4] = cog;
        elementsThatEffectRobot[5] = flag;

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

    public TwoFourPusher getPusher() {
        return pusher;
    }

    public IElement[] boardEffects() {
        return elementsThatEffectRobot;
    }
}
