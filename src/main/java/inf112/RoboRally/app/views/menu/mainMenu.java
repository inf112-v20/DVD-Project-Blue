package inf112.RoboRally.app.views.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.RoboRally.app.views.showBoard;
import inf112.RoboRally.app.gameScreen;
/*
Class for the main menu. This is where the game starts when built.
 */
public class mainMenu implements Screen {

    private gameScreen gameScreen;
    private Stage stage;

    public mainMenu (gameScreen game) {
        this.gameScreen = game;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.center();

        Texture background = new Texture("Images/Background.png");
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        table.setBackground(new TextureRegionDrawable(background));

        TextButton play = new button().createTextButton("PLAY");
        TextButton lan = new button().createTextButton("LAN");
        TextButton quit = new button().createTextButton("QUIT");
        table.add(play);
        table.row().padTop(10);
        table.add(lan);
        table.row().padTop(10);
        table.add(quit);

        play.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameScreen.setScreen(new showBoard(gameScreen));
                super.clicked(event, x, y);
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
                Gdx.app.exit();
                super.clicked(event, x, y);
            }
        });

        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameScreen.batch.begin();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1));
        stage.draw();
        gameScreen.batch.end();
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
        stage.dispose();
    }
}