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
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private Texture mapTexture;
    private Image mapImg;

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public PlayScreen(GameLauncher game) {
        this.gameLauncher = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        table = new Table();
        table.setFillParent(true);
        table.center().padTop(150);

        Texture background = new Texture("Images/Background2.png");
        background.setFilter(Linear, Linear);
        table.setBackground(new TextureRegionDrawable(background));

        mapTexture = new Texture(gameLauncher.currentMapImg);
        mapTexture.setFilter(Linear, Linear);
        mapImg = new Image(mapTexture);

        Label mapNameLabel = new Label("Choose map: ", skin);
        TextButton mapButton = new Button().createTextButton(gameLauncher.currentMapName);

        Label playerCountLabel = new Label("Player count: ", skin);
        TextButton playersButton = new Button().createTextButton(String.format("%01d", gameLauncher.settings().getPlayerCount()));

        TextButton start = new Button().createTextButton("START");
        TextButton goBack = new Button().createTextButton("GO BACK");

        table.add(mapNameLabel);
        table.add(mapButton).width(750f);
        table.row().padTop(25);
        table.add(mapImg).colspan(2).center();
        table.row().padTop(25);
        table.add(playerCountLabel);
        table.add(playersButton).width(200f);
        table.row().padTop(25);
        table.add(start).colspan(2).center();
        table.row().padTop(25);
        table.add(goBack).colspan(2).center();

        mapButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameLauncher.settings().chooseMap();
                gameLauncher.currentMapName = gameLauncher.settings().getMap().getMapName();
                gameLauncher.currentMapImg = gameLauncher.settings().getMap().getMapImg();
                mapButton.getLabel().setText(gameLauncher.currentMapName);
                mapImg.setDrawable(new TextureRegionDrawable(new Texture(gameLauncher.currentMapImg)));
            }
        });

        playersButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameLauncher.settings().choosePlayerCount();
            }
        });

        start.addListener(new ClickListener() {
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

        goBack.addListener(new ClickListener() {
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
}
