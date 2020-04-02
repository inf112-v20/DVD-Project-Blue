package inf112.RoboRally.app.views.robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class OldRobotView extends Sprite {

    private final int Y_PIXEL_POSITION_MULT = 100;
    private final int X_PIXEL_POSITION_MULT = 100;
    private int yPositionAdjustment = 15;
    private final int X_PIXEL_POSITION_ADJUSTMENT = 10;
    private final int SPRITE_MOVEMENT_SPEED = 100;


    private float targetX;
    private float targetY;
    private Pos pos; // not needed?

    public OldRobotView(Sprite sprite, Pos startPos, Direction startDirection, int playerNumber) {
        super(sprite);
        setYPositionAdjustment(playerNumber);
        setStartDirection(startDirection); // sprite is initially pointed upward
        setStartPosition(startPos);
    }

    @Override
    public void draw(Batch batch) {
//        update(Gdx.graphics.getDeltaTime());
        update(Gdx.graphics.getDeltaTime());
//        updateX(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    private void update(float delta) {
//        System.out.println(getX());
//        System.out.println(targetX);
        if (getX() < targetX)
            setX(getX() + SPRITE_MOVEMENT_SPEED * delta);
        if (getY() < targetY)
            setY(getY() + SPRITE_MOVEMENT_SPEED * delta);
    }

    public void updateX(int x) {
        targetX = getX() + ( x * X_PIXEL_POSITION_MULT );
    }

    public void updateY(int y) {
        targetY = getY() + ( y * Y_PIXEL_POSITION_MULT );
    }

    public void updateDirection(Rotation rotation) {
        switch (rotation) {
            case LEFT:
                rotate90(false);
                return;
            case RIGHT:
                rotate90(true);
                return;
            case UTURN:
                rotate90(true);
                rotate90(true);
                return;
            default:
                throw new IllegalArgumentException("RobotView is told to rotate '"+rotation+"', which is not supported");
        }

    }


    private void setStartDirection(Direction startDirection) {
        switch (startDirection) {
            case RIGHT:
                rotate90(true);
                return;
            case LEFT:
                rotate90(false);
                return;
            case DOWN:
                rotate90(true);
                rotate90(true);
                return;
            case UP:
                return;
            default:
                throw new IllegalStateException("RobotView was given start direction '"+startDirection+"', which is not supported");
        }
    }


    private void setStartPosition(Pos startPos) {
        setX( (startPos.x() * X_PIXEL_POSITION_MULT) - X_PIXEL_POSITION_ADJUSTMENT );
        setCenterY( (startPos.y() * Y_PIXEL_POSITION_MULT) + yPositionAdjustment);
    }

    private void setYPositionAdjustment(int playerNumber) {
        if      (playerNumber <= 1) yPositionAdjustment = 15; // funker
        else if (playerNumber == 2) yPositionAdjustment = 5;  // funker
        else if (playerNumber == 3) yPositionAdjustment = 25; // funker
        else if (playerNumber == 4) yPositionAdjustment = -5; // funker
        else if (playerNumber == 5) yPositionAdjustment = 30; // funker
        else if (playerNumber == 6) yPositionAdjustment = -5; // funker
        else if (playerNumber == 7) yPositionAdjustment = 40; // funker
        else throw new IllegalArgumentException("RobotView was given playernumber '"+playerNumber+"', which is too high for this game");



    }


}
