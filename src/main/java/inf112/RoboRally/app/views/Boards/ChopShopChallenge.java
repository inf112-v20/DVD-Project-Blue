package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class ChopShopChallenge {

    private Position player1StartPosition = new Position(6, 8);
    private Direction player1StartDirection = Direction.RIGHT;

    private Position player2StartPosition = new Position(6, 7);
    private Direction player2StartDirection = Direction.RIGHT;

    private final String mapName = "Chop Shop Challenge";
    private final String fileName = "Boards/ChopShopChallenge.tmx";
    private final String mapImage = "Boards/ChopShopChallenge.png";

    public String getMapName() {
        return mapName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMapImage() {
        return mapImage;
    }

    public Position getPlayer1StartPosition() {
        return player1StartPosition;
    }

    public Direction getPlayer1StartDirection() {
        return player1StartDirection;
    }

    public Position getPlayer2StartPosition() {
        return player2StartPosition;
    }

    public Direction getPlayer2StartDirection() {
        return player2StartDirection;
    }
}
