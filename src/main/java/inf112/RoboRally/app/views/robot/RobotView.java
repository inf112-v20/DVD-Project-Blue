package inf112.RoboRally.app.views.robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;

public class RobotView extends Sprite {

    private final int Y_PIXEL_POSITION_MULT = 100;
    private final int X_PIXEL_POSITION_MULT = 100;
//    private final int Y_PIXEL_POSITION_ADJUSTMENT = 10;
//    private final int X_PIXEL_POSITION_ADJUSTMENT = 10;

    private Vector2 vector2 = new Vector2();
    private Pos pos; // not needed?

    public RobotView(Sprite sprite, Pos startPos, Direction startDirection) {
        super(sprite);
        setStartDirection(startDirection); // sprite is initially pointed upward
        setStartPosition(startPos);
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    private void update(float delta) {
        setX(getX() + vector2.x * delta);
        setY(getY() + vector2.y * delta);
    }

    public void move(int x, int y) {
        vector2.x += x;
        vector2.y += y;
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
        setX( (startPos.getX() * X_PIXEL_POSITION_MULT)  ); // -
        setCenterY( (startPos.getY() * Y_PIXEL_POSITION_MULT) ); // +
    }


}
