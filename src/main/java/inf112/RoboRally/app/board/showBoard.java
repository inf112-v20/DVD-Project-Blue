package inf112.RoboRally.app.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import inf112.RoboRally.app.gameScreen;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.RoboRally.app.player.playerHud;

import javax.swing.text.TabExpander;
import javax.swing.text.TextAction;

public class showBoard extends InputAdapter implements Screen {

    private gameScreen gameScreen;
    private Stage stage;
    private playerHud playerHud;
    private Texture playerTexutre;
    private TextureRegion[] playerTexutreRegion;
    private TiledMapTileLayer playerLayer;
    private TiledMapTileLayer.Cell playerCell;

    private TmxMapLoader mapLoader;
    private TiledMap map;

    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public showBoard (gameScreen game) {
        this.gameScreen = game;
        playerHud = new playerHud(gameScreen.batch);
    }

    @Override
    public void show() {
        mapLoader = new TmxMapLoader();
        classicBoard classicBoard = new classicBoard();
        map = mapLoader.load(classicBoard.getFileName());

        playerLayer = (TiledMapTileLayer) map.getLayers().get("player");
        playerTexutre = new Texture("Robots/emojiBots/angryBot.png");
        playerTexutreRegion = new TextureRegion[1];
        playerTexutreRegion[0] = new TextureRegion(playerTexutre, 0, 0,256, 256);
        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTexutreRegion[0]));

        mapRenderer = new OrthogonalTiledMapRenderer(map, 1/256f);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 28, 16);
        camera.update();
        mapRenderer.setView(camera);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        playerLayer.setCell(6, 8, playerCell);
        gameScreen.batch.setProjectionMatrix(playerHud.stage.getCamera().combined);
        playerHud.stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

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
        map.dispose();
        mapRenderer.dispose();
    }
}
