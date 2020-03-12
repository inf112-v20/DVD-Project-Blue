package inf112.RoboRally.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.RoboRally.app.controllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.views.Screens.MainMenu;

public class GameLauncher extends Game {

    public static final int GAME_WIDTH = 2560;
    public static final int GAME_HEIGHT = 1440;
    public String currentMapName;
    public String currentMapImg;
    private SinglePlayerSettingsController settings;
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        settings = new SinglePlayerSettingsController();
        currentMapName = settings.getMap().name();
        currentMapImg = settings.getMap().imgFile();
        setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public SinglePlayerSettingsController settings() {
        return settings;
    }
}
