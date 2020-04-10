package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;

public class Player {

    // player variables
    private TiledMapTileLayer.Cell playerCell, playerCellDead, playerCellWon;
    private Vector2 playerVector;
    private Texture playerTexture;
    private TextureRegion[] playerTextureRegion;

    public Player(int x, int y) {
        playerTexture = new Texture("Tiles/ExampleRobots.png");
        playerTextureRegion = new TextureRegion[3];
        playerTextureRegion[0] = new TextureRegion(playerTexture, 0, 0, 48, 48);
        playerTextureRegion[1] = new TextureRegion(playerTexture, 48, 0, 48, 48);
        playerTextureRegion[2] = new TextureRegion(playerTexture, 96, 0, 48, 48);
        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[0]));
        playerCellDead = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[1]));
        playerCellWon = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerTextureRegion[2]));
        playerVector = new Vector2();
        playerVector.set(x, y);
    }

    public Vector2 getPlayerVector() {
        return playerVector;
    }

    public TiledMapTileLayer.Cell getPlayerCell() {
        return playerCell;
    }

    public TiledMapTileLayer.Cell getPlayerCellDead() {
        return playerCellDead;
    }

    public TiledMapTileLayer.Cell getPlayerCellWon() {
        return playerCellWon;
    }
}
