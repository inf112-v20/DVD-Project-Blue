package inf112.RoboRally.app.controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.views.robot.RobotView;

public class RobotViewController {

    // game stat
    private int playerNumber;

    // files
    private final String IMAGE_PATH = "Robots/colorBotsSmaller/Player";
    private final String FILE_EXTENSION = ".png";

    // view image
    private Texture robotTexture;

    // the view
    private RobotView robotView;

    public RobotViewController(int playerNumber, Pos startPos) {
        this.playerNumber = playerNumber;
        robotTexture = new Texture(IMAGE_PATH+playerNumber+FILE_EXTENSION);
        robotView = new RobotView(new Sprite(robotTexture));
        robotView.setVector(startPos);
    }

    public RobotView getRobotView() {
        return robotView;
    }
}
