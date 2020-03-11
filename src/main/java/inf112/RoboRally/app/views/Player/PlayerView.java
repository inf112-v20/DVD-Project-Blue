package inf112.RoboRally.app.views.Player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.MapSystem.MapController;

public class PlayerView {

    public Player player;
    private MapController mapController;

    private Sprite playerSprite;
    public TiledMapTileLayer playerLayer;
    public TiledMapTileLayer.Cell playerCell;
    public Vector2 playerVector;

    public PlayerView() {
//        this.playerSprite = playerSprite;
//        player = new Player(GameScreen.map.getStartPos(), GameScreen.map.getStartDirection(), 1);
//        playerLayer = (TiledMapTileLayer) GameScreen.map.getMap().getLayers().get("player");
//        playerSprite = new Sprite(new Texture("Robots/emojiBots/angryBot.png"));
//        playerCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(playerSprite));
//        playerVector = new Vector2();
//        playerVector.set(player.getRobot().getX(), player.getRobot().getY());
//        playerCell.setRotation(player.getRobot().getDirection().CellDirectionNumber());
    }

}
