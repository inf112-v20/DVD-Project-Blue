package inf112.RoboRally.app.views.robot;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class RobotView extends Sprite {

    // View
    private TiledMapTileLayer boardLayer;
    private TiledMapTileLayer.Cell boardCell;
    private Sprite sprite;

    // Position data
    private Direction direction;    //enumerated in 'Direction'
    private Vector2 vector2;

    // Player game information
    int playerNumber;

    public RobotView(int playerNumber, Sprite sprite, Pos startPos, Direction startDirection) {
        this.playerNumber = playerNumber;
        this.sprite = sprite;
        vector2 = new Vector2(startPos.x(), startPos.y());
        direction = startDirection;
    }


    public void setUpAtBoard(TiledMapTileLayer boardLayer) {
        this.boardLayer = boardLayer;
        boardCell = new TiledMapTileLayer.Cell().setTile(new StaticTiledMapTile(sprite));
        boardCell.setRotation(direction.CellDirectionNumber());
        boardLayer.setCell((int) vector2.x, (int) vector2.y, boardCell);
    }

    public void updateView(int x, int y, Direction direction) {
        boardLayer.setCell((int) vector2.x, (int) vector2.y, null);
        vector2.x = x; vector2.y = y;
        this.direction = direction;
        boardLayer.setCell((int) vector2.x, (int) vector2.y, boardCell);
        boardCell.setRotation(this.direction.CellDirectionNumber());
    }


}
