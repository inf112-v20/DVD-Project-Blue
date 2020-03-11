package inf112.RoboRally.app.views.MapSystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.SinglePlayerSettings;
import inf112.RoboRally.app.models.board.IRobot;
import inf112.RoboRally.app.models.board.Robot;
import inf112.RoboRally.app.views.Boards.IBoard;
import inf112.RoboRally.app.views.Boards.VaultAssault;

public class MapController {

    private TmxMapLoader mapLoader;
    private IBoard board;
    private TiledMap map;
    private GameLauncher launcher;
    private IRobot[] robots = new IRobot[8];

    //Maps
    public VaultAssault classicBoard = new VaultAssault();

    public MapController(SinglePlayerSettings settings) {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(settings.getMap().getFilePath());
        board = settings.getMap();
//        IRobot r = new Robot(new Sprite(new Texture("Robots/emojiBots/angryBot.png")), this, 1);
        for (int i = 1; i <= settings.getPlayerCount(); i++) {
            robots[i] = new Robot(new Sprite(new Texture("Robots/colorBots/player"+i+".png")), this, i);
        }
    }

    public TiledMap getMap () {
        return map;
    }

    public IBoard getBoard() {
        return board;
    }

    public int getWidth() {
        return map.getProperties().get("width", Integer.class);
    }

    public int getHeight() {
        return map.getProperties().get("height", Integer.class);
    }

    public IRobot[] getRobots() {
        return robots;
    }
}
