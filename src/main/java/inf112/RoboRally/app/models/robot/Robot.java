package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.NewGame;

public class Robot implements IRobot {

    // Position
    private Direction direction;
    private Pos pos;

    // Game stats
    private final int MAX_HP = 9;
    private final int STARTING_LIVES = 3;
    private int hp;
    private int lives;

    public Robot(NewGame game, int playerNumber) {
        hp = MAX_HP;
        lives = STARTING_LIVES;
        pos = game.getBoard().getRobotStartingPos(playerNumber);
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
    }

    @Override
    public void move(int steps) {
        System.out.println("FROM Robot: I was told to a certain amount of steps");
        switch (direction) {
            case UP:
                pos.updateY(steps);
                break;
            case DOWN:
                pos.updateY(-steps);
                break;
            case RIGHT:
                pos.updateX(steps);
                break;
            case LEFT:
                pos.updateX(-steps);
                break;
            default:
                throw new IllegalStateException("robot has direction '"+direction+"', which is supported");
        }
    }

    @Override
    public void rotate(Rotation rotation) {
        System.out.println("FROM Robot: I was told to rotate");
        switch (rotation) {
            case LEFT:
                direction = direction.rotateLeft();
                break;
            case RIGHT:
                direction = direction.rotateRight();
                break;
            case UTURN:
                direction = direction.rotateRight();
                direction = direction.rotateRight();
                break;
            default:
                throw new IllegalArgumentException("robot is told to rotate '"+rotation+"', which is not supported");
        }
    }

    public Pos position() {
        return pos;
    }

    @Override
    public void looseHP() {
        hp--;
    }

    @Override
    public int getHP() {
        return hp;
    }
}
