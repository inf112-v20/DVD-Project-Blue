package inf112.RoboRally.app.views.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PlayerMovementDemo extends Sprite implements InputProcessor {

    private Vector2 vector2 = new Vector2();
    private float speed = 60 * 2;

    public PlayerMovementDemo (Sprite sprite) {
        super(sprite);
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta) {
        setX(getX() + vector2.x * delta);
        setY(getY() + vector2.y * delta);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            vector2.y = speed;
        }
        if (keycode == Input.Keys.DOWN) {
            vector2.y = -speed;
        }
        if (keycode == Input.Keys.LEFT) {
            vector2.x = -speed;
        }
        if (keycode == Input.Keys.RIGHT) {
            vector2.x = speed;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP) {
            vector2.y = 0;
        }
        if (keycode == Input.Keys.DOWN) {
            vector2.y = 0;
        }
        if (keycode == Input.Keys.LEFT) {
            vector2.x = 0;
        }
        if (keycode == Input.Keys.RIGHT) {
            vector2.x = 0;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
