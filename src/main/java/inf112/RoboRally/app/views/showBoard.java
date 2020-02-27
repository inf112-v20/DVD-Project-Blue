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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.cards.forwardCard;
import inf112.RoboRally.app.models.cards.reverseCard;
import inf112.RoboRally.app.models.cards.rotateCard;
import inf112.RoboRally.app.gameScreen;
import inf112.RoboRally.app.models.game.Player;
/*
God class that currently holds initializes and renders all views, and where thus far achieved connection between view
 and logic where robot model is being moved by card model is programmed. The hard focus of the next delivery will be
separating rendering, and initialization of maps, tiles and models.
 */
public class showBoard extends InputAdapter implements Screen {

    private gameScreen gameScreen;
    public Stage stage;
    private playerHud playerHud;
    private cardButtonsForMovementDemo cardHud;

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
    private OrthographicCamera camera;

    public showBoard (gameScreen game) {
        this.gameScreen = game;
        stage = new Stage();
        playerHud = new playerHud(gameScreen.batch);
        cardHud = new cardButtonsForMovementDemo();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        mapLoader = new TmxMapLoader();
        classicBoard classicBoard = new classicBoard();
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
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 28, 16);
        camera.update();
        mapRenderer.setView(camera);

        stage.addActor(cardHud.create());

        // Button for card that moves robot one step forward
        cardHud.move1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                forwardCard move1Forward = new forwardCard(1000, 1);
                move1Forward.moveRobot(player1.getRobot());
                playerVector.set(player1.getRobot().getX(), player1.getRobot().getY());

                super.clicked(event, x, y);
            }
        });

        // Button for card that moves robot two steps forward
        cardHud.move2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                forwardCard move2Forward = new forwardCard(800, 2);
                move2Forward.moveRobot(player1.getRobot());
                playerVector.set(player1.getRobot().getX(), player1.getRobot().getY());

                super.clicked(event, x, y);
            }
        });

        // Button for card that moves robot three steps forward
        cardHud.move3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                forwardCard move3Forward = new forwardCard(1100, 3);
                move3Forward.moveRobot(player1.getRobot());
                playerVector.set(player1.getRobot().getX(), player1.getRobot().getY());

                super.clicked(event, x, y);
            }
        });

        // Button for card that moves robot one step back
        cardHud.moveBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                reverseCard moveBack = new reverseCard(550);
                moveBack.moveRobot(player1.getRobot());
                playerVector.set(player1.getRobot().getX(), player1.getRobot().getY());

                super.clicked(event, x, y);
            }
        });

        // Button for card that rotates robot to the left
        cardHud.rotateLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                rotateCard rotateLeft = new rotateCard(1300, Rotation.LEFT);
                rotateLeft.moveRobot(player1.getRobot());
                playerCell.setRotation(player1.getRobot().getDirection().CellDirectionNumber());

                super.clicked(event, x, y);
            }
        });

        // Button for card that rotates robot to the right
        cardHud.rotateRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                rotateCard rotateRight = new rotateCard(900, Rotation.RIGHT);
                rotateRight.moveRobot(player1.getRobot());
                playerCell.setRotation(player1.getRobot().getDirection().CellDirectionNumber());

                super.clicked(event, x, y);
            }
        });

        // Button for card that turns robot around
        cardHud.uTurn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // removing the layer at the location the robot is moving from
                playerLayer.setCell((int)playerVector.x, (int)playerVector.y, null);

                rotateCard uTurn = new rotateCard(750, Rotation.UTURN);
                uTurn.moveRobot(player1.getRobot());
                playerCell.setRotation(player1.getRobot().getDirection().CellDirectionNumber());

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