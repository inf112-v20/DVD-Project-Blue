package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.Robot.Direction;

/*
Model for boards in the game. Not worked on yet.
 */
public class Board {

    // map and file name
    private String mapName;
    private String filePath;

    // starting position data
    private Vector2[] robotStartVectors;
    private Direction[] robotStartDirections;

    private int width;
    private int height;

    // walls
    // lasers
    // other pieces

    public Board() {}

    public int amountOfPlayerSupportedOnThisMap() {
        if (robotStartVectors.length != robotStartDirections.length) {
            throw new IllegalStateException("Start direction list and start vector list does not match in length");
        }
        return robotStartVectors.length;
    }

    public Vector2 getRobotStartingVector(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartVectors.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartVectors[playerNumber-1];
    }

    public Direction getRobotStartingDirection(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartDirections.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartDirections[playerNumber-1];
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
}