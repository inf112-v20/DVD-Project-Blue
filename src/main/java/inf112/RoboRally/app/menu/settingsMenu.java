package inf112.RoboRally.app.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.RoboRally.app.gameScreen;

public class settingsMenu implements Screen {

    private gameScreen gameScreen;
    private Stage stage;
    private Skin buttonStyle = new buttonStyle().getButtonSkin();

    TextButton changeResolution;
    TextButton soundOn;
    TextButton back;

    public settingsMenu (gameScreen game) {
        this.gameScreen = game;
        stage = new Stage(new ScreenViewport());
        //User input
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.center();

        changeResolution = new TextButton("Change Resolution", buttonStyle);
        changeResolution.setTransform(true);
        soundOn = new TextButton("Sound ON", buttonStyle);
        soundOn.setTransform(true);
        back = new TextButton("Back", buttonStyle);
        back.setTransform(true);
        table.add(changeResolution);
        table.row().padTop(10);
        table.add(soundOn);
        table.row().padTop(10);
        table.add(back);

        //Button actions
        changeResolution.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        soundOn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                gameScreen.setScreen(new mainMenu(gameScreen));
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
