package inf112.RoboRally.app.models.board;

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
public class Robot implements IRobot {

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
        switch (direction) {
            case UP:
                vector2.y = vector2.y + steps;
                return;
            case DOWN:
                vector2.y = vector2.y - steps;
                return;
            case RIGHT:
                vector2.x = vector2.x + steps;
                return;
            case LEFT:
                vector2.x = vector2.x - steps;
                return;
            default:
                throw new IllegalStateException("robot has direction '"+direction+"', which is supported");
        }
    }

    @Override
    public void rotate(Rotation rotation) {
        switch (rotation) {
            case LEFT:
                direction.rotateLeft();
                return;
            case RIGHT:
                direction.rotateRight();
                return;
            case UTURN:
                direction.rotateRight();
                direction.rotateRight();
                return;
            default:
                throw new IllegalArgumentException("robot is told to rotate '"+rotation+"', which is not supported");
        }
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
