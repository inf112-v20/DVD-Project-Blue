package inf112.RoboRally.app.models.robot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.views.robot.RobotView;

public class RobotViewController {

    // the view
    private RobotView robotView;

    public RobotViewController(int playerNumber, Pos startPos) {

        // view image
        Texture robotTexture = new Texture("assets/smallrobot/player" + playerNumber + ".png");
        robotTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        robotView = new RobotView(new Sprite(robotTexture),  startPos);

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

}
