package inf112.RoboRally.app.views.MapSystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.SinglePlayerSettings;
import inf112.RoboRally.app.models.board.IRobot;
import inf112.RoboRally.app.models.board.Robot;
import inf112.RoboRally.app.views.Boards.IBoard;

public class MapController {

    private TmxMapLoader mapLoader;
    private IBoard board;
    private TiledMap map;
    private IRobot[] robots = new IRobot[8];

    public MapController(SinglePlayerSettings settings) {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(settings.getMap().getFilePath());
        board = settings.getMap();
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            robots[i] = new Robot(new Sprite(new Texture("Robots/colorBots/player"+(i+1)+".png")), this, i+1);
        }
    }

    public TiledMap getMap () {
        return map;
    }

    public IBoard getBoard() {
        return board;
    }

    public IRobot[] getRobots() {
        return robots;
    }
}
