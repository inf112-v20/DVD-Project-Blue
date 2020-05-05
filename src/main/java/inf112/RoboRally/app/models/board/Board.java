package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

/*
Model for boards in the game. Not worked on yet.
 */
public class Board {

    // map and file name
    private String mapName;
    private String filePath;

    // starting position data
    private Pos[] robotStartPositions; // new version
    private Vector2[] robotStartVectors;
    private Direction[] robotStartDirections;

    private final int Y_LOWER_BOUND = 3;
    private final int Y_UPPER_BOUND = 14;
    private final int X_LOWER_BOUND = 5;
    private final int X_UPPER_BOUND = 20;


    public Board() {}

    public int amountOfPlayerSupportedOnThisMap() {
        if (robotStartPositions.length != robotStartDirections.length) {
            throw new IllegalStateException("Start direction list and start vector list does not match in length");
        }
        return robotStartPositions.length;
    }

    public Pos getRobotStartingPos(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartPositions.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartPositions[playerNumber];
    }

    public Vector2 getRobotStartingVector(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartVectors.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartVectors[playerNumber];
    }

    public Direction getRobotStartingDirection(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartDirections.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartDirections[playerNumber];
    }

    public void setRobotStartPositions(Pos[] robotStartPositions) {
        this.robotStartPositions = robotStartPositions;
    }

    public void setRobotStartVectors(Vector2[] robotStartVectors) {
        this.robotStartVectors = robotStartVectors;
    }

    public void setRobotStartDirections(Direction[] robotStartDirections) {
        this.robotStartDirections = robotStartDirections;
    }

    public void setFilePath(String name) {
        filePath = name;
    }

    public String tiledMapFile() {
        return filePath+".tmx";
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String name() {
        return mapName;
    }

    public String imgFile() {
        return filePath+".png";
    }

    public int getY_LOWER_BOUND() {
        return Y_LOWER_BOUND;
    }

    public int getY_UPPER_BOUND() {
        return Y_UPPER_BOUND;
    }

    public int getX_LOWER_BOUND() {
        return X_LOWER_BOUND;
    }

    public int getX_UPPER_BOUND() {
        return X_UPPER_BOUND;
    }
}