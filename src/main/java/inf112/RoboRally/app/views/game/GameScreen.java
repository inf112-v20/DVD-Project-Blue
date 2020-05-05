package inf112.RoboRally.app.views.game;

import com.badlogic.gdx.*;
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
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.views.player.Bullet;
import inf112.RoboRally.app.views.player.PlayerUI;
import inf112.RoboRally.app.views.player.Timer;
import inf112.RoboRally.app.views.robot.RobotView;

import java.util.ArrayList;

public class GameScreen extends InputAdapter implements Screen {

    private final String PATH = "assets/smallrobot/player";

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private OrthogonalTiledMapRenderer mapRenderer;
    private static Game game;
    private PlayerUI playerUI;
    private RobotView[] robotViews;

    private InputMultiplexer multiplexer;
    private Timer timer;

    //shooting
    ArrayList<Bullet> bullets;
    public static final float SHOOT_WAIT_TIME = 1f;
    float shootTimer;
    //shooting

    public GameScreen(GameLauncher launcher) {
        // rendering stuff
        this.gameLauncher = launcher;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);

        // setting up the game and board
        game = new Game(gameLauncher.settings());
        robotViews = new RobotView[game.getGameCardController().numberOfPlayers()];
        TiledMap tiledMap = game.setUpMadLoader().getMap();


//        playerUI = new PlayerUI(game.getHumanPlayer(), game.getGameCardController()); // working
        playerUI = game.getHumanPlayer().getPlayerUI();

        timer = new Timer(60);
        stage.addActor(timer.getTimeTable());

        //shooting
        bullets = new ArrayList<Bullet>();
        shootTimer = 0;
        //shooting

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

        timer.updateTimer(Gdx.graphics.getDeltaTime());
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
            robotViews[playerNumber].draw(gameLauncher.batch);

            if (robotViews[playerNumber].isDeadThisRound()) {
                robotViews[playerNumber].setTexture(new Texture(PATH+playerNumber+"dead.png"));
            } else {
                robotViews[playerNumber].setTexture(new Texture(PATH+playerNumber+".png"));
            }

            if ( robotViews[playerNumber].capturedFirstFlag() ) {
                robotViews[playerNumber].setTexture(new Texture(PATH+playerNumber+"flag1.png"));
                if (robotViews[playerNumber].capturedSecondFlag()) {
                    robotViews[playerNumber].setTexture(new Texture(PATH+playerNumber+"flag2.png"));
                    if (robotViews[playerNumber].capturedThirdFlag()) {
                        robotViews[playerNumber].setTexture(new Texture(PATH+playerNumber+"won.png"));
                    }
                }
            }


        }

        //shooting
        shootTimer += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && shootTimer >= SHOOT_WAIT_TIME) {
            shootTimer = 0;
            if (players[0].robot().direction() == Direction.UP ||
                    players[0].robot().direction() == Direction.DOWN) {
                bullets.add(new Bullet(robotViews[0].getX()+40, robotViews[0].getY()+47));
            } else if (players[0].robot().direction() == Direction.RIGHT ||
                    players[0].robot().direction() == Direction.LEFT) {
                bullets.add(new Bullet(robotViews[0].getX()+47, robotViews[0].getY()+40));
            }
        }

        ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
        for (Bullet bullet : bullets) {
            bullet.update(Gdx.graphics.getDeltaTime(), players[0].robot().direction());
            if (bullet.remove) {
                bulletsToRemove.add(bullet);
            }
        }
        bullets.removeAll(bulletsToRemove);
        //shooting

        //shooting
        for (Bullet bullet : bullets) {
            bullet.render(gameLauncher.batch);
        }
        //shooting

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
