package inf112.RoboRally.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.RoboRally.app.views.MapList;
import inf112.RoboRally.app.views.Screens.MainMenu;

public class GameLauncher extends Game {

    public static final int GAME_WIDTH = 2560;
    public static final int GAME_HEIGHT = 1440;
    public MapList mapList;
    public String currMapName;
    public String currMapPath;
    public String currMapImg;
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        mapList = new MapList();
        currMapName = mapList.getCurrentMapName();
        currMapPath = mapList.getCurrentMapPath();
        currMapImg = mapList.getCurrentMapImage();
        setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
