package inf112.RoboRally.app.models.robot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;
import org.lwjgl.Sys;

/*
Model of a robot. Initialized with position and direction. This information is passed on by
the board it is initialized on.
 */
public class Robot implements IRobot {

    // Position
    private Vector2 vector2;
    private Direction direction;

    // Views
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer.Cell boardCell;
    private Sprite sprite;

    // Robot stats
    private final int MAX_HP = 9;
    private final int STARTING_LIVES = 3;
    private int HP;
    private int lives;

    //MAP
    private static Game game;
    //MAP

    public Robot(Game game, int playerNumber) {
        this.game = game;
        HP = MAX_HP;
        lives = STARTING_LIVES;
        setupOnBoard(game, playerNumber);
    }

    // bare bones constructor used for testing
    public Robot() {
        HP = MAX_HP;
        lives = STARTING_LIVES;
    }

    // for testing
    public Robot(int x, int y) {
        vector2 = new Vector2(x, y);
        direction = Direction.RIGHT;
    }



    @Override
    public void move(int steps) {
        System.out.println("FROM Robot: I was told to a certain amount of steps");
        removeOldPositionOnBoard();
        switch (direction) {
            case UP:
                if (game.getWallLayerCell((int)vector2.x, (int)vector2.y) != null && game.getWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 85) {
                    break;
                } else if (game.getDoubleWallLayerCell((int)vector2.x, (int)vector2.y) != null &&
                        (game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 97 || game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 98)) {
                    break;
                } else if (game.getPusherLayerCell((int)vector2.x, (int)vector2.y) != null) {
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 113 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 115) {
                        vector2.y--;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 114 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 116) {
                        vector2.y++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 121 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 123) {
                        vector2.x++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 122 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 124) {
                        vector2.x--;
                        break;
                    }
                } else {
                    vector2.y = vector2.y + steps;
                    break;
                }
            case DOWN:
                if (game.getWallLayerCell((int)vector2.x, (int)vector2.y) != null && game.getWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 86) {
                    break;
                } else if (game.getDoubleWallLayerCell((int)vector2.x, (int)vector2.y) != null &&
                        (game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 105 || game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 106)) {
                    break;
                } else if (game.getPusherLayerCell((int)vector2.x, (int)vector2.y) != null) {
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 113 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 115) {
                        vector2.y--;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 114 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 116) {
                        vector2.y++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 121 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 123) {
                        vector2.x++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 122 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 124) {
                        vector2.x--;
                        break;
                    }
                } else {
                    vector2.y = vector2.y - steps;
                    break;
                }
            case RIGHT:
                if (game.getWallLayerCell((int)vector2.x, (int)vector2.y) != null && game.getWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 94) {
                    break;
                } else if (game.getDoubleWallLayerCell((int)vector2.x, (int)vector2.y) != null &&
                        (game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 98 || game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 106)) {
                    break;
                } else if (game.getPusherLayerCell((int)vector2.x, (int)vector2.y) != null) {
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 113 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 115) {
                        vector2.y--;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 114 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 116) {
                        vector2.y++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 121 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 123) {
                        vector2.x++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 122 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 124) {
                        vector2.x--;
                        break;
                    }
                } else {
                    vector2.x = vector2.x + steps;
                    break;
                }
            case LEFT:
                if (game.getWallLayerCell((int)vector2.x, (int)vector2.y) != null && game.getWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 93) {
                    break;
                } else if (game.getDoubleWallLayerCell((int)vector2.x, (int)vector2.y) != null &&
                        (game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 97 || game.getDoubleWallLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 105)) {
                    break;
                } else if (game.getPusherLayerCell((int)vector2.x, (int)vector2.y) != null) {
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 113 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 115) {
                        vector2.y--;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 114 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 116) {
                        vector2.y++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 121 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 123) {
                        vector2.x++;
                        break;
                    }
                    if (game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 122 || game.getPusherLayer().getCell((int)vector2.x, (int)vector2.y).getTile().getId() == 124) {
                        vector2.x--;
                        break;
                    }
                } else {
                    vector2.x = vector2.x - steps;
                    break;
                }
            default:
                throw new IllegalStateException("robot has direction '"+direction+"', which is supported");
        }
        updateOnBoard();
    }


    @Override
    public void rotate(Rotation rotation) {
        System.out.println("FROM Robot: I was told to rotate");
        removeOldPositionOnBoard();
        switch (rotation) {
            case LEFT:
                direction = direction.rotateLeft();
                break;
            case RIGHT:
                direction = direction.rotateRight();
                break;
            case UTURN:
                direction = direction.rotateRight();
                direction = direction.rotateRight();
                break;
            default:
                throw new IllegalArgumentException("robot is told to rotate '"+rotation+"', which is not supported");
        }
        updateOnBoard();
    }

    private void removeOldPositionOnBoard() {
        boardLayer.setCell((int) vector2.x, (int) vector2.y, null); // setting its prev cell to null - the robot is not there anymore
    }

    private void updateOnBoard() {
        // setting cell in accordance with current direction and vector values
        boardCell.setRotation(direction.CellDirectionNumber());
        boardLayer.setCell((int) vector2.x, (int) vector2.y, boardCell);
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
        boardLayer = (TiledMapTileLayer) game.getMap().getLayers().get("player");
        this.sprite = new Sprite(new Texture("Robots/colorBots/player"+(playerNumber+1)+".png"));
        boardCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(sprite));
        boardCell.setRotation(direction.CellDirectionNumber());
        boardLayer.setCell((int) vector2.x,(int) vector2.y, boardCell);
    }

    // for testing
    public int getX() {
        return (int) vector2.x;
    }

    // for testing
    public int getY() {
        return (int) vector2.y;
    }

    // for testing
    public Direction getDirection() {
        return direction;
    }

}
