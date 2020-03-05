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

/*
Class for the main menu. This is where the game starts when built.
 */
public class MainMenu implements Screen {

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;

    public MainMenu(GameLauncher game) {
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

        Texture background = new Texture("Images/Background.png");
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        table.setBackground(new TextureRegionDrawable(background));

        TextButton play = new Button().createTextButton("PLAY");
        TextButton lan = new Button().createTextButton("LAN");
        TextButton quit = new Button().createTextButton("QUIT");
        table.add(play);
        table.row().padTop(10);
        table.add(lan);
        table.row().padTop(10);
        table.add(quit);

        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getRoot().addAction(Actions.sequence(Actions.fadeOut(0.8f), Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        gameLauncher.setScreen(new PlayScreen(gameLauncher));
                    }
                })));
            }
        });

        lan.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                super.clicked(event, x, y);
            }
        });

        quit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getRoot().addAction(Actions.sequence(Actions.fadeOut(0.5f), Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        Gdx.app.exit();
                    }
                })));
            }
        });

        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameLauncher.batch.begin();
        gameLauncher.batch.setProjectionMatrix(camera.combined);
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
