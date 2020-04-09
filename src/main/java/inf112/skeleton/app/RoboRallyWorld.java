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
    private TiledMapTileLayer.Cell playerCell, playerCellDead, playerCellWon;
    private Vector2 playerVector;
    private Texture playerTexture;
    private TextureRegion[] playerTextureRegion;

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
        playerTexture = new Texture("Tiles/ExampleRobots.png");
        playerTextureRegion = new TextureRegion[3];
        playerTextureRegion[0] = new TextureRegion(playerTexture, 0, 0, 48, 48);
        playerTextureRegion[1] = new TextureRegion(playerTexture, 48, 0, 48, 48);
        playerTextureRegion[2] = new TextureRegion(playerTexture, 96, 0, 48, 48);
        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[0]));
        playerCellDead = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[1]));
        playerCellWon = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[2]));
        playerVector = new Vector2();
        playerVector.set(0, 0);

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
        playerLayer.setCell((int) playerVector.x, (int) playerVector.y, playerCell);
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
        if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 30) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
            //TOP
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 29) {
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
            //RIGHT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 24) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            //LEFT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 23) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            //TOP LEFT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 19) {
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            //TOP RIGHT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 20) {
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            //BOTTOM LEFT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 25) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
            //BOTTOM RIGHT
        } else if (map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 26) {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            //GO ELSE WHERE
        } else {
            if (keycode == Input.Keys.UP) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y += 1;
            }
            if (keycode == Input.Keys.DOWN) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.y -= 1;
            }
            if (keycode == Input.Keys.LEFT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x -= 1;
            }
            if (keycode == Input.Keys.RIGHT) {
                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
                playerVector.x += 1;
            }
        }


//        if ((map.getLayerCell((int) playerVector.x, (int) playerVector.y) != null) && (map.getWallLayer().getCell((int) playerVector.x, (int) playerVector.y)).getTile().getId() == 30)) {
//            if (keycode == Input.Keys.UP) {
//                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
//                playerVector.y += 1;
//            }
//            if (keycode == Input.Keys.DOWN) {
//                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
//                playerVector.y -= 1;
//            }
//            if (keycode == Input.Keys.LEFT) {
//                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
//                playerVector.x -= 1;
//            }
//            if (keycode == Input.Keys.RIGHT) {
//                playerLayer.setCell((int) playerVector.x, (int) playerVector.y, null);
//                playerVector.x += 1;
//            }
//        }

        return super.keyUp(keycode);
    }
}
