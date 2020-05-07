package inf112.RoboRally.app.controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.views.robot.RobotView;

public class RobotViewController {

    // files
    private final String IMAGE_PATH = "assets/smallrobot/player";
    private final String FILE_EXTENSION = ".png";

    // view image
    private Texture robotTexture;

    // the view
    private RobotView robotView;

    public RobotViewController(int playerNumber, Pos startPos, Direction startDirection) {
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

    public void touchedFlag() {
        robotView.capturedFlag();
    }

    public void updateViewToDead() {
        robotView.setDeadThisRound(true);
    }

    public void updateViewToAlive() {
        robotView.setDeadThisRound(false);
    }

    public void hasWon() {
        robotView.setToWinSprite();
    }

    public void updateViewPoweredDown(boolean powerDown) {
        robotView.changePoweredDown(powerDown);
    }

    public void timeToShoot(boolean shoot) {
        robotView.setTimeToShoot(shoot);
    }
}
