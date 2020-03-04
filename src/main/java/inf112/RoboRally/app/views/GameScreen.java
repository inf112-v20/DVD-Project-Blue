package inf112.RoboRally.app.views;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.models.cards.ForwardCard;
import inf112.RoboRally.app.models.cards.ReverseCard;
import inf112.RoboRally.app.models.cards.RotateCard;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.views.Player.PlayerView;

public class GameScreen extends InputAdapter implements Screen {

    private GameLauncher gameScreen;
    public OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private OrthogonalTiledMapRenderer mapRenderer;
    public static MapController map;
    private PlayerUI playerUI;
    private PlayerView playerView;

    private InputMultiplexer multiplexer;

    public GameScreen(GameLauncher game) {
        this.gameScreen = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);
        playerUI = new PlayerUI(gameScreen.batch);

        map = new MapController();

        playerView = new PlayerView();
        mapRenderer = new OrthogonalTiledMapRenderer(map.getMap(), 1/256f);
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
        gameScreen.batch.begin();

        gameScreen.batch.setProjectionMatrix(camera.combined);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();

        mapRenderer.render();

        gameScreen.batch.setProjectionMatrix(playerUI.getStage().getCamera().combined);
        playerUI.getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        playerUI.getStage().draw();

        playerView.playerLayer.setCell((int)playerView.playerVector.x, (int)playerView.playerVector.y, playerView.playerCell);
        gameScreen.batch.end();
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
        gameScreen.batch.dispose();
        playerUI.dispose();
        mapRenderer.dispose();
    }

    //JUST FOR TESTING AT THE MOMENT
    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP) {
            playerView.playerLayer.setCell((int) playerView.playerVector.x, (int) playerView.playerVector.y, null);
            ForwardCard move1Forward = new ForwardCard(1000, 1);
            move1Forward.moveRobot(playerView.player.getRobot());
            playerView.playerVector.set(playerView.player.getRobot().getX(), playerView.player.getRobot().getY());
        }

        if (keycode == Input.Keys.DOWN) {
            playerView.playerLayer.setCell((int) playerView.playerVector.x, (int) playerView.playerVector.y, null);
            playerView.playerLayer.setCell((int)playerView.playerVector.x, (int)playerView.playerVector.y, null);
            ReverseCard moveBack = new ReverseCard(550);
            moveBack.moveRobot(playerView.player.getRobot());
            playerView.playerVector.set(playerView.player.getRobot().getX(), playerView.player.getRobot().getY());
        }

        if (keycode == Input.Keys.LEFT) {
            playerView.playerLayer.setCell((int) playerView.playerVector.x, (int) playerView.playerVector.y, null);
            RotateCard rotateLeft = new RotateCard(1300, Rotation.LEFT);
            rotateLeft.moveRobot(playerView.player.getRobot());
            playerView.playerCell.setRotation(playerView.player.getRobot().getDirection().CellDirectionNumber());
        }
        if (keycode == Input.Keys.RIGHT) {
            playerView.playerLayer.setCell((int) playerView.playerVector.x, (int) playerView.playerVector.y, null);
            RotateCard rotateRight = new RotateCard(900, Rotation.RIGHT);
            rotateRight.moveRobot(playerView.player.getRobot());
            playerView.playerCell.setRotation(playerView.player.getRobot().getDirection().CellDirectionNumber());
        }
        return super.keyUp(keycode);
    }
}
