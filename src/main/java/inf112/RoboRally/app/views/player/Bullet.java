package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {

    public static final int SPEED = 500;
    private Texture bulletTexture;
    float x, y;

    public boolean remove = false;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        if (bulletTexture == null) {
            bulletTexture = new Texture("assets/smallrobot/Laser.png");
        }
    }

    public void update(float delta) {
        y += SPEED*delta;
        if (y > 1440) {
            remove = true;
        }
    }

    public void render(SpriteBatch sb) {
        sb.draw(bulletTexture, x, y);
    }

}
