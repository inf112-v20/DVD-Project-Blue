package inf112.RoboRally.app.views.robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import inf112.RoboRally.app.models.robot.Pos;

public class RobotView extends Sprite {


    private Vector2 vector2;
    private float speed = 80 * 2; // not needed when moving with cards?

    public RobotView(Sprite sprite) {
        super(sprite);
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

    // for setting start vector
    public void setVector(Pos pos) {
        vector2 = new Vector2(pos.getX(), pos.getY());
    }


}
