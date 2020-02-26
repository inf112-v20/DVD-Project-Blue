package inf112.RoboRally.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.RoboRally.app.views.menu.mainMenu;

public class gameScreen extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new mainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
