package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.board.Direction;

public interface IBoard {

    Vector2 getRobotStartingVector(int playerNumber);

    Direction getRobotStartingDirection(int playerNumber);

    String getFilePath();

}
