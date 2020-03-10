package inf112.RoboRally.app.models.board;

import com.badlogic.gdx.Gdx;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveHorizontal(int x) {
        this.x += x;
    }

    public void moveVertical(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
