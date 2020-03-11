package inf112.RoboRally.app.views.Screens;

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
import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class PlayScreen implements Screen {

    private GameLauncher gameLauncher;
    private Viewport viewport;
    private Stage stage;


    // skin for buttons
    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    // table for buttons
    private Table table = new Table();

    // start game and go back to main menu button
    private final TextButton START = new Button().createTextButton("START");
    private final TextButton BACK = new Button().createTextButton("GO BACK");

    // button for choosing map
    private final Label MAP_NAME_LABEL = new Label("Choose map: ", SKIN);
    private TextButton mapButton;        // will change according to user input
    private Image mapImg;                // will change according to user input

    // button for choosing amount of players
    private final Label PLAYER_COUNT_LABEL = new Label("Player count: ", SKIN);
    TextButton playersButton;           // will change according to user input




    public PlayScreen(GameLauncher gameLauncher) {
        this.gameLauncher = gameLauncher;
        OrthographicCamera camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        setUpTable();
        /*
        Input listeners for the buttons
         */
        // choosing the map
        mapButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameLauncher.settings().chooseMap();
                mapButton.getLabel().setText(gameLauncher.settings().getMap().getMapName());
                mapImg.setDrawable(new TextureRegionDrawable(new Texture(gameLauncher.settings().getMap().getMapImg())));
            }
        });

        // choosing the amount of AI players
        playersButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playersButton.getLabel().setText(gameLauncher.settings().choosePlayerCount());
            }
        });

        // start the game button
        START.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getRoot().addAction(Actions.sequence(Actions.fadeOut(0.8f), Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        gameLauncher.setScreen(new GameScreen(gameLauncher));
                    }
                })));
            }
        });

        // go back to main menu button
        BACK.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getRoot().addAction(Actions.sequence(Actions.fadeOut(0.8f), Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        gameLauncher.setScreen(new MainMenu(gameLauncher));
                    }
                })));
            }
        });

        stage.addActor(table);
        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(Actions.fadeIn(0.8f));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
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

    private void setUpTable() {
        // set background
        Texture background = new Texture("Images/Background2.png");
        background.setFilter(Linear, Linear);

        table.setFillParent(true);
        table.center().padTop(150);
        table.setBackground(new TextureRegionDrawable(background));

        mapButton = new Button().createTextButton(this.gameLauncher.settings().getMap().getMapName());
        playersButton = new Button().createTextButton(String.format("%01d", gameLauncher.settings().getPlayerCount()));
        mapImg = new Image(new Texture(gameLauncher.settings().getMap().getMapImg()));

        table.add(MAP_NAME_LABEL);
        table.add(mapButton).width(750f);
        table.row().padTop(25);
        table.add(mapImg).colspan(2).center();
        table.row().padTop(25);
        table.add(PLAYER_COUNT_LABEL);
        table.add(playersButton).width(200f);
        table.row().padTop(25);
        table.add(START).colspan(2).center();
        table.row().padTop(25);
        table.add(BACK).colspan(2).center();
    }

}
