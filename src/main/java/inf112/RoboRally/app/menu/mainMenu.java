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
import inf112.RoboRally.app.board.showBoard;
import inf112.RoboRally.app.gameScreen;

public class mainMenu implements Screen {

    private gameScreen gameScreen;
    private Stage stage;

    TextButton play;
    TextButton lan;
    TextButton settings;
    TextButton quit;

    public mainMenu (gameScreen game) {
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

        //Theme for button
        Skin skin = new Skin(Gdx.files.internal("neonSkin/neon-ui.json"));

        //Play, settings, quit button
        play = new TextButton("Play", skin);
        play.setTransform(true);
        play.scaleBy(2f);
        lan = new TextButton("LAN", skin);
        lan.setTransform(true);
        lan.scaleBy(2f);
        settings = new TextButton("Settings", skin);
        settings.setTransform(true);
        settings.scaleBy(2f);
        quit = new TextButton("Quit", skin);
        quit.setTransform(true);
        quit.scaleBy(2f);

        table.add(play).padRight(125);
        table.row().padTop(50);
        table.add(lan).padRight(125);
        table.row().padTop(50);
        table.add(settings).padRight(175);
        table.row().padTop(50);
        table.add(quit).padRight(125);

        //Button actions
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                gameScreen.setScreen(new showBoard(gameScreen));
            }
        });

        settings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
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
