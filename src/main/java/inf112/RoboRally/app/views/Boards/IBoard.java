package inf112.RoboRally.app.views.Boards;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.Robot.Direction;

public interface IBoard {

    String getMapName();

    String getMapImg();

    Vector2 getRobotStartingVector(int playerNumber);

    Direction getRobotStartingDirection(int playerNumber);

    String getFilePath();

}
