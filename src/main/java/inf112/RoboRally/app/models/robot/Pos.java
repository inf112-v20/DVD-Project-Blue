package inf112.RoboRally.app.models.robot;

public class Pos {

    private final int START_X;
    private final int START_Y;
    private int x;
    private int y;

    public Pos(int x, int y) {
        START_X = x;
        START_Y = y;
        this.x = x;
        this.y = y;
    }

    public void restart() {
        this.x = START_X;
        this.y = START_Y;
    }

    public void setX(int x) {
        this.x += x;
    }

    public void setY(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
