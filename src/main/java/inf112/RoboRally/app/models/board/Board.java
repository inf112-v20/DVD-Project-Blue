package inf112.RoboRally.app.models.board;

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
    private Pos[] robotStartPositions;
    private Direction[] robotStartDirections;


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


    public Direction getRobotStartingDirection(int playerNumber) {
        if (playerNumber < 0 || playerNumber > robotStartDirections.length) {
            throw new IllegalArgumentException("Amount of players given is not supported on this map");
        }
        return robotStartDirections[playerNumber];
    }

    public void setRobotStartPositions(Pos[] robotStartPositions) {
        this.robotStartPositions = robotStartPositions;
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