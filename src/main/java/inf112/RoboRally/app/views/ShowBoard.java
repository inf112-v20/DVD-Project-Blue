package inf112.RoboRally.app.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameScreen;
import inf112.RoboRally.app.Main;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.cards.Card;

/*
God class that currently holds initializes and renders all views, and where thus far achieved connection between view
 and logic where robot model is being moved by card model is programmed. The hard focus of the next delivery will be
separating rendering, and initialization of maps, tiles and models.
 */
public class ShowBoard extends InputAdapter implements Screen {

    private GameScreen gameScreen;
    private OrthographicCamera camera;
    private Viewport viewport;
    public Stage stage;
    private PlayerUI playerUI;
    private Card card;

    /*
    Hardcoded player views will be abstracted in a player view soon
    */
    //player1
    private Sprite playerSprite;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer.Cell playerCell;
    public Vector2 playerVector;

    private TmxMapLoader mapLoader;
    private TiledMap map;

    private OrthogonalTiledMapRenderer mapRenderer;

    public ShowBoard(GameScreen game) {
        this.gameScreen = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, camera);
        stage = new Stage(viewport);
        playerUI = new PlayerUI(gameScreen.batch);
        card = new Card();
        Gdx.input.setInputProcessor(playerUI.stage);
    }

    @Override
    public void show() {
        mapLoader = new TmxMapLoader();
        ClassicBoard classicBoard = new ClassicBoard();
        map = mapLoader.load(classicBoard.getFileName());


        Player player1 = new Player(classicBoard.getPlayer1StartPosition(), classicBoard.getPlayer1StartDirection(), 1);

        //player1
        playerLayer = (TiledMapTileLayer) map.getLayers().get("player");
        playerSprite = new Sprite(new Texture("Robots/emojiBots/angryBot.png"));
        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerSprite));
        playerVector = new Vector2();
        playerVector.set(player1.getRobot().getX(), player1.getRobot().getY());
        playerCell.setRotation(player1.getRobot().getDirection().CellDirectionNumber());

        mapRenderer = new OrthogonalTiledMapRenderer(map, 1/256f);
        camera.setToOrtho(false, 28, 16);
        camera.update();
        mapRenderer.setView(camera);
        //stage.addActor(card.move1(1));

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameScreen.batch.begin();


        gameScreen.batch.setProjectionMatrix(camera.combined);
        mapRenderer.render();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();
        playerUI.stage.draw();
        playerUI.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        playerLayer.setCell((int)playerVector.x, (int)playerVector.y, playerCell);


        gameScreen.batch.end();
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
        gameScreen.batch.dispose();
        map.dispose();
        mapRenderer.dispose();
    }
}
