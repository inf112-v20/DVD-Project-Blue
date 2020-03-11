package inf112.RoboRally.app.views.Boards;

/*
Passes on information about the board to showBard. This structure will change soon.
 */
public class RobotStew {

//    private Position player1StartPosition = new Position(6, 8);
//    private Direction player1StartDirection = Direction.RIGHT;
//
//    private Position player2StartPosition = new Position(6, 7);
//    private Direction player2StartDirection = Direction.RIGHT;

    private final String mapName = "Robot Stew";
    private final String fileName = "Boards/RobotStew.tmx";
    private final String mapImage = "Boards/RobotStew.png";

    public String getMapName() {
        return mapName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMapImage() {
        return mapImage;
    }

}
