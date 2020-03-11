package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.views.MapSystem.MapController;

/*
Model of a robot. Initialized with position and direction. This information is passed on by
the board it is initialized on.
 */
public class Robot extends InputAdapter implements IRobot {

    // Position
    private Vector2 vector2;
    private Direction direction;

    // Views
    private TiledMapTileLayer layer;
    private TiledMapTileLayer.Cell cell;
    private Sprite sprite;

    // Game stats
    private final int MAX_HP = 9;
    private int HP;
    private int lives;
    private int playerNumber;

    public Robot(Sprite sprite, MapController mapCon, int playerNumber) {
        this.playerNumber = playerNumber;
        HP = MAX_HP;
        lives = 3;
        setupOnBoard(sprite, mapCon);
    }

    @Override
    public void move(int steps) {

    }

    @Override
    public void rotate(Rotation rotation) {

    }

    @Override
    public void looseHP() {

    }

    @Override
    public void getHP() {

    }

    @Override
    public int getPlayerNumber() {
        return playerNumber;
    }

    private void setupOnBoard(Sprite sprite, MapController mapCon) {
        direction = mapCon.getBoard().getRobotStartingDirection(playerNumber);
        vector2 = mapCon.getBoard().getRobotStartingVector(playerNumber);
        layer = (TiledMapTileLayer) mapCon.getMap().getLayers().get("player");
        this.sprite = sprite;
        cell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(sprite));
        cell.setRotation(direction.CellDirectionNumber());
        layer.setCell((int) vector2.x,(int) vector2.y, cell);
    }


}
