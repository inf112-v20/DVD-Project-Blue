package inf112.RoboRally.app.views.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.player.PlayerUI;
import inf112.RoboRally.app.views.robot.RobotView;

public class GameScreenForTesting extends InputAdapter implements Screen {

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private OrthogonalTiledMapRenderer mapRenderer;
    private static Game game;
    private PlayerUI playerUI;
    private Player[] players;
    private RobotView[] robotViews;


    public GameScreenForTesting(GameLauncher launcher) {
        // rendering stuff
        this.gameLauncher = launcher;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);

        // setting up the game and board
        gameLauncher.settings().setPlayerCountTo1();
        game = new Game(gameLauncher.settings());
        robotViews = new RobotView[1];
        TiledMap tiledMap = game.setUpMadLoader().getMap();
        playerUI = game.getHumanPlayer().getPlayerUI();

        // rendering, camera, and input processors
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/256f);
        camera.setToOrtho(false, 26, 15);
        mapRenderer.setView(camera);
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);
        multiplexer.addProcessor(playerUI.getStage());
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

        // depreciated
        gameLauncher.batch.begin();

        // drawing the robots
        players = game.players();
        int playerNumber = 0;
        robotViews[playerNumber] = players[playerNumber].robot().getRobotViewController().getRobotView();
        RobotView robotView = robotViews[playerNumber];
        robotView.draw(gameLauncher.batch);
        gameLauncher.batch.end();
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

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP) {
            players[0].robot().move(1);
        } else if (keycode == Input.Keys.DOWN) {
            players[0].robot().move(-1);
        } else if (keycode == Input.Keys.LEFT) {
            players[0].robot().rotate(Rotation.LEFT);
        } else if (keycode == Input.Keys.RIGHT) {
            players[0].robot().rotate(Rotation.RIGHT);
        }
        return super.keyUp(keycode);
    }


}
