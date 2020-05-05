package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.RoboRally.app.models.robot.Direction;

public class Bullet {

    public static final int SPEED = 1000;
    private Texture bulletTexture;
    float x, y;

    public boolean remove = false;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update(float delta, Direction direction) {
        if (bulletTexture == null && (direction == Direction.UP || direction == Direction.DOWN)) {
            bulletTexture = new Texture("assets/smallrobot/LaserV.png");
        } else if (bulletTexture == null && (direction == Direction.RIGHT || direction == Direction.LEFT)) {
            bulletTexture = new Texture("assets/smallrobot/LaserH.png");
        }

        if (direction == Direction.UP) {
            y += SPEED*delta;
        } else if (direction == Direction.DOWN) {
            y -= SPEED*delta;
        } else if (direction == Direction.RIGHT) {
            x += SPEED*delta;
        } else if (direction == Direction.LEFT) {
            x -= SPEED*delta;
        }

        if (x < 0 || y < 0 || y > 1440 || x > 2560) {
            remove = true;
        }
    }

    public void render(SpriteBatch sb) {
        sb.draw(bulletTexture, x, y);
    }

}
