package inf112.RoboRally.app.views.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.views.player.PlayerUI;

public class GameScreen extends InputAdapter implements Screen {

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private OrthogonalTiledMapRenderer mapRenderer;
    private static Game game;
    private PlayerUI playerUI;

    //player movement smooth
    private PlayerMovementDemo playerMovementDemo;
    private Texture playerTxt;
    //player movement smooth

    private InputMultiplexer multiplexer;

    public GameScreen(GameLauncher launcher) {
        this.gameLauncher = launcher;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);

        game = new Game(gameLauncher.settings());
        playerUI = new PlayerUI(game.getGameCardController());

        mapRenderer = new OrthogonalTiledMapRenderer(game.getMap(), 1/256f);
        camera.setToOrtho(false, 26, 15);
        mapRenderer.setView(camera);

        //player movement smooth
        playerTxt = new Texture("Robots/colorBotsSmaller/player1.png");
        playerTxt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        playerMovementDemo = new PlayerMovementDemo(new Sprite(playerTxt));
        //player movement smooth

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);
        multiplexer.addProcessor(playerUI.getStage());

        //player movement smooth
        multiplexer.addProcessor(playerMovementDemo);
        //player movement smooth

        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        gameLauncher.batch.begin();

        gameLauncher.batch.setProjectionMatrix(camera.combined);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();

        mapRenderer.render();

        gameLauncher.batch.setProjectionMatrix(playerUI.getStage().getCamera().combined);
        playerUI.getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        playerUI.getStage().draw();

        gameLauncher.batch.end();

        //player movement smooth
        gameLauncher.batch.begin();
        playerMovementDemo.draw(gameLauncher.batch);
        gameLauncher.batch.end();
        //player movement smooth
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        playerUI.getStage().getViewport().update(width, height);
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
        gameLauncher.batch.dispose();
        playerUI.dispose();
        mapRenderer.dispose();
    }
}
