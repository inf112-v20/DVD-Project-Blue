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
import inf112.RoboRally.app.views.ClassicBoard;

import java.util.ArrayList;
import java.util.ListIterator;

public class PlayScreen implements Screen {

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private int playerCount = 2;

    //maps
    private ClassicBoard classicBoard;

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
        table.center();

        Texture background = new Texture("Images/Background2.png");
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        table.setBackground(new TextureRegionDrawable(background));

        Texture mapTexture = new Texture("Boards/VaultAssault.png");
        mapTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image mapImg = new Image(mapTexture);

        Label mapNameLabel = new Label("Choose map: ", skin);
        TextButton mapButton = new Button().createTextButton("MAP");

        Label playerCountLabel = new Label("Player count: ", skin);
        TextButton playersButton = new Button().createTextButton(String.format("%01d", playerCount));

        TextButton start = new Button().createTextButton("START");

        table.add(mapNameLabel);
        table.add(mapButton);
        table.row();
        table.add(mapImg);
        table.row();
        table.add(playerCountLabel);
        table.add(playersButton);
        table.row();
        table.add(start);

        playersButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (playerCount < 8) {
                    playerCount++;
                    playersButton.getLabel().setText(playerCount);
                } else {
                    playerCount = 2;
                    playersButton.getLabel().setText(playerCount);
                }
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
