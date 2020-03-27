package inf112.RoboRally.app.models.robot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;

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

    // Robot stats
    private final int MAX_HP = 9;
    private int HP;
    private int lives;

    public Robot(Game game, int playerNumber) {
        HP = MAX_HP;
        lives = 3;
        setupOnBoard(game, playerNumber);
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
    public int getHP() {
        return HP;
    }

    private void setupOnBoard(Game game, int playerNumber) {
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
        vector2 = game.getBoard().getRobotStartingVector(playerNumber);
        layer = (TiledMapTileLayer) game.getMap().getLayers().get("player");
        this.sprite = new Sprite(new Texture("Robots/colorBots/player"+(playerNumber)+".png"));
        cell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(sprite));
        cell.setRotation(direction.CellDirectionNumber());
        layer.setCell((int) vector2.x,(int) vector2.y, cell);
    }

}
