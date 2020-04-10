package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

public class RoboRallyWorld extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;

    private Map map;

    // camera variables
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    // player variables
    private TiledMapTileLayer playerLayer;
    private Player player;

    // opponent variables
    private TiledMapTileLayer opponentLayer;
    private Player opponent;

    private boolean playerTurn = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

        // keyboard input
        Gdx.input.setInputProcessor(this);

        map = new Map();

        // player code
        playerLayer = map.getMapLayers("Player");
        player = new Player(0, 0);

        // opponent code
        opponentLayer = map.getMapLayers("Player");
        opponent = new Player(2, 0);

        // mapRenderer anc camera code
        mapRenderer = new OrthogonalTiledMapRenderer(map.getMap());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 576, 576);
        camera.position.x = 288;
        camera.position.y = 288;
        camera.update();
        mapRenderer.setView(camera);
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        map.getMap().dispose();
        mapRenderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCell());
        opponentLayer.setCell((int) opponent.getPlayerVector().x, (int) opponent.getPlayerVector().y, opponent.getPlayerCell());
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean keyUp(int keycode) {
            //BOTTOM
        if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 30) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
            //TOP
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 29) {
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
            //RIGHT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 24) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            //LEFT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 23) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            //TOP LEFT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 19) {
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            //TOP RIGHT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 20) {
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            //BOTTOM LEFT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 25) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
            //BOTTOM RIGHT
        } else if (map.getWallLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getWallLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 26) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            //WIN? A BIT BUGGY
        } else if (map.getFlagLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (((map.getFlagLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 1) ||
                (map.getFlagLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 1 ||
                (map.getFlagLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 2 ||
                (map.getFlagLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 3)) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellWon());
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellWon());
                player.getPlayerVector().y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellWon());
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellWon());
                player.getPlayerVector().x += 1;
            }
            //HOLE? A BIT BUGGY
        } else if (map.getHoleLayerCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y) != null && (map.getHoleLayer().getCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y)).getTile().getId() == 6) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellDead());
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellDead());
                player.getPlayerVector().y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellDead());
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, player.getPlayerCellDead());
                player.getPlayerVector().x += 1;
            }
            //GO ELSE WHERE
        } else {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) player.getPlayerVector().x, (int) player.getPlayerVector().y, null);
                player.getPlayerVector().x += 1;
            }
        }
        return super.keyUp(keycode);
    }
}
