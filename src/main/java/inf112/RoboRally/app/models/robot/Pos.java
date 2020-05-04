package inf112.RoboRally.app.models.robot;

public class Pos {

    private int restartX;
    private int restartY;
    private int x;
    private int y;

    public Pos(int x, int y) {
        restartX = x;
        restartY = y;
        this.x = x;
        this.y = y;
    }

    public void setNewRestrtPos(int x, int y) {
        restartX = x; restartY = y;
    }

    public void restart() {
        this.x = restartX; this.y = restartY;
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
