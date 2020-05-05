package inf112.RoboRally.app.controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.views.robot.RobotView;

public class RobotViewController {

    // game stat
    private int playerNumber;

    // files
    private final String IMAGE_PATH = "assets/smallrobot/player";
    private final String FILE_EXTENSION = ".png";
    private final String DEAD_BOT_IMAGE_PATH = "deadBot";

    // view image
    private Texture robotTexture;

    // the view
    private RobotView robotView;

    public RobotViewController(int playerNumber, Pos startPos, Direction startDirection) {
        this.playerNumber = playerNumber;
        robotTexture = new Texture(IMAGE_PATH+playerNumber+FILE_EXTENSION);
        robotTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        robotView = new RobotView(new Sprite(robotTexture),  startPos, startDirection);
    }


    public void updateXCord(int x) {
        robotView.updateX(x);
    }

    public void updateYCord(int y) {
        robotView.updateY(y);
    }

    public RobotView getRobotView() {
        return robotView;
    }

    public void updateDirection(Direction startDirection) {
        robotView.setStartDirection();
    }


    public void touchedFlag(int flagsCaptured) {
        robotView.setFlags(flagsCaptured);
    }

    public void updateViewToDead() {
        robotView.setDeadThisRound(true);
    }

    public void updateViewToAlive() {
        robotView.setDeadThisRound(false);
    }


    public void resetDir() {
        robotView.setStartDirection();
        robotView.setRotation(270.0f);
    }


}
