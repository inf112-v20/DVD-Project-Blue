package inf112.RoboRally.app.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.RoboRally.app.gameScreen;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.RoboRally.app.player.cardHud;
import inf112.RoboRally.app.player.playerHud;

public class showBoard extends InputAdapter implements Screen {

    private gameScreen gameScreen;
    public Stage stage;
    private playerHud playerHud;
    private cardHud cardHud;

    private Sprite playerSprite;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer.Cell playerCell;
    public Vector2 playerVector;

    private TmxMapLoader mapLoader;
    private TiledMap map;

    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public showBoard (gameScreen game) {
        this.gameScreen = game;
        stage = new Stage();
        playerHud = new playerHud(gameScreen.batch);
        cardHud = new cardHud();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        mapLoader = new TmxMapLoader();
        classicBoard classicBoard = new classicBoard();
        map = mapLoader.load(classicBoard.getFileName());

        playerLayer = (TiledMapTileLayer) map.getLayers().get("player");
        playerSprite = new Sprite(new Texture("Robots/emojiBots/angryBot.png"));
        playerSprite.setRotation(45);
        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerSprite));
        playerVector = new Vector2();
        playerVector.set(10, 8);

        mapRenderer = new OrthogonalTiledMapRenderer(map, 1/256f);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 28, 16);
        camera.update();
        mapRenderer.setView(camera);

        stage.addActor(cardHud.create());

        cardHud.move.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() == 0){
                    playerVector.y += 1;
                }
                if (playerCell.getRotation() == 1){
                    playerVector.x -= 1;
                }
                if (playerCell.getRotation() == 2){
                    playerVector.y -= 1;
                }
                if (playerCell.getRotation() == 3){
                    playerVector.x += 1;
                }
                super.clicked(event, x, y);
            }
        });

        cardHud.move2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() == 0){
                    playerVector.y += 2;
                }
                if (playerCell.getRotation() == 1){
                    playerVector.x -= 2;
                }
                if (playerCell.getRotation() == 2){
                    playerVector.y -= 2;
                }
                if (playerCell.getRotation() == 3){
                    playerVector.x += 2;
                }
                super.clicked(event, x, y);
            }
        });

        cardHud.move3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() == 0){
                    playerVector.y += 3;
                }
                if (playerCell.getRotation() == 1){
                    playerVector.x -= 3;
                }
                if (playerCell.getRotation() == 2){
                    playerVector.y -= 3;
                }
                if (playerCell.getRotation() == 3){
                    playerVector.x += 3;
                }
                super.clicked(event, x, y);
            }
        });

        cardHud.moveBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() == 0){
                    playerVector.y -= 1;
                }
                if (playerCell.getRotation() == 1){
                    playerVector.x += 1;
                }
                if (playerCell.getRotation() == 2){
                    playerVector.y += 1;
                }
                if (playerCell.getRotation() == 3){
                    playerVector.x -= 1;
                }
                super.clicked(event, x, y);
            }
        });

        cardHud.rotateLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() >= 4) {
                    playerCell.setRotation(0);
                }
                playerCell.setRotation(playerCell.getRotation()+1);
                super.clicked(event, x, y);
            }
        });

        cardHud.rotateRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                if (playerCell.getRotation() == 0) {
                    playerCell.setRotation(4);
                }
                playerCell.setRotation(playerCell.getRotation()-1);
                super.clicked(event, x, y);
            }
        });

        cardHud.uTurn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);
                playerCell.setRotation(playerCell.getRotation()+2);
                super.clicked(event, x, y);
            }
        });

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();
        gameScreen.batch.setProjectionMatrix(playerHud.stage.getCamera().combined);
        playerHud.stage.draw();
        playerLayer.setCell((int)playerVector.x, (int)playerVector.y, playerCell);
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
        playerHud.stage.dispose();
    }
}
