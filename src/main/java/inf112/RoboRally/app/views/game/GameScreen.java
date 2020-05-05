package inf112.RoboRally.app.views.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.player.PlayerUI;
import inf112.RoboRally.app.views.robot.OldRobotView;

public class GameScreen extends InputAdapter implements Screen {

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private OrthogonalTiledMapRenderer mapRenderer;
    private static Game game;
    private PlayerUI playerUI;
    private OldRobotView[] robotViews;

    private InputMultiplexer multiplexer;

    public GameScreen(GameLauncher launcher) {
        // rendering stuff
        this.gameLauncher = launcher;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);

        // setting up the game and board
        game = new Game(gameLauncher.settings());
        robotViews = new OldRobotView[game.getGameCardController().numberOfPlayers()];
        TiledMap tiledMap = game.setUpMadLoader().getMap();


//        playerUI = new PlayerUI(game.getHumanPlayer(), game.getGameCardController()); // working
        playerUI = game.getHumanPlayer().getPlayerUI();

        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/256f);
        camera.setToOrtho(false, 26, 15);
        mapRenderer.setView(camera);
        multiplexer = new InputMultiplexer();
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
        Player[] players = game.players();
        for (int playerNumber = 0; playerNumber < players.length; playerNumber++) {
            robotViews[playerNumber] = players[playerNumber].robot().getRobotViewController().getRobotView();
//            robotViews[playerNumber].setGameScreen(this);
            robotViews[playerNumber].draw(gameLauncher.batch);
            if ( robotViews[playerNumber].hasOneFlag() ) {
                robotViews[playerNumber].setTexture(new Texture("assets/smallrobot/player"+playerNumber+"flag.png"));
            }
        }

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

    public void updateTexture(int playerNumber, Texture texture) {
        robotViews[playerNumber].setTexture(texture);
    }
}
