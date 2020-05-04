package inf112.RoboRally.app.controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.views.robot.OldRobotView;

public class RobotViewController {

    // game stat
    private int playerNumber;

    // files
    private final String IMAGE_PATH = "assets/smallrobot/Player";
    private final String FILE_EXTENSION = ".png";

    // view image
    private Texture robotTexture;

    // the view
    private OldRobotView robotView;

    public RobotViewController(int playerNumber, Pos startPos, Direction startDirection) {
        this.playerNumber = playerNumber;
        robotTexture = new Texture(IMAGE_PATH+playerNumber+FILE_EXTENSION);
        robotTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        robotView = new OldRobotView(new Sprite(robotTexture), startPos, startDirection);
    }

    public void setToPosition(Pos pos) {
        robotView.setStartPosition(pos);
    }

    public void updateXCordRobotView(int x) {
        robotView.updateX(x);
    }

    public void updateYCordRobotView(int y) {
        robotView.updateY(y);
    }

    public OldRobotView getRobotView() {
        return robotView;
    }
}
