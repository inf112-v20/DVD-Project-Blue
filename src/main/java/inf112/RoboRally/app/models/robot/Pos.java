package inf112.RoboRally.app.models.robot;

public class Pos {

    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveHorizontal(int x) {
        this.x += x;
    }

    public void moveVertical(int y) {
        this.y += y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String toString() {
        return x+", "+y;
    }
}
