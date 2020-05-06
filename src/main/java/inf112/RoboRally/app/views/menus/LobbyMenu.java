package inf112.RoboRally.app.views.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.lan.Client;
import inf112.RoboRally.app.lan.Server;

import java.io.IOException;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class LobbyMenu implements Screen {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private Server server;
    private Client client;
    private boolean host;

    public LobbyMenu(GameLauncher game, boolean host) throws IOException {
        this.gameLauncher = game;
        this.host = host;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);


        server = new Server();
        client = new Client();
        //new Thread(client).start();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        table = new Table();
        table.setFillParent(true);
        table.center();

        Texture background = new Texture("Images/Background2.png");
        background.setFilter(Linear, Linear);
        table.setBackground(new TextureRegionDrawable(background));

        if (host) {
            new Thread(server).start();
        } else {
            new Thread(client).start();
        }


        stage.addActor(table);
        stage.getRoot().

                getColor().a = 0;
        stage.getRoot().

                addAction(Actions.fadeIn(0.8f));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameLauncher.batch.begin();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();
        gameLauncher.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
