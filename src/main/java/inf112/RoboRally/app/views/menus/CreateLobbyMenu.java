package inf112.RoboRally.app.views.menus;

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

import java.io.IOException;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class CreateLobbyMenu implements Screen {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private GameLauncher gameLauncher;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Stage stage;
    private Table table;

    public CreateLobbyMenu(GameLauncher game) {
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
        background.setFilter(Linear, Linear);
        table.setBackground(new TextureRegionDrawable(background));

        Label hostLabel = new Label("Enter your name:", SKIN);
        TextField hostName = new TextField("", SKIN);
        hostName.setMessageText("NAME");

        Label mapNameLabel = new Label("Choose map: ", SKIN);
        TextButton mapButton = new Button().createTextButton(this.gameLauncher.settings().getMap().name());
        Image mapImg = new Image(new Texture(gameLauncher.settings().getMap().imgFile()));

        TextButton createGame = new Button().createTextButton("CREATE");
        TextButton goBack = new Button().createTextButton("GO BACK");

        table.add(hostLabel).padRight(70);
        table.add(hostName).width(750).center();
        table.row();
        table.add(mapNameLabel).padBottom(25).padRight(20);
        table.add(mapButton).padBottom(25).width(750);
        table.row();
        table.add(mapImg).colspan(2).padBottom(20);
        table.row();
        table.add(createGame);
        table.add(goBack);

        mapButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameLauncher.settings().chooseMap();
                mapButton.getLabel().setText(gameLauncher.settings().getMap().name());
                mapImg.setDrawable(new TextureRegionDrawable(new Texture(gameLauncher.settings().getMap().imgFile())));
            }
        });

        createGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.getRoot().addAction(Actions.sequence(Actions.fadeOut(0.8f), Actions.run(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            gameLauncher.setScreen(new LobbyMenu(gameLauncher, true, hostName.getText()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                        gameLauncher.setScreen(new LanMenu(gameLauncher));
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
