package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;

public class Robot implements IRobot {

    // Position
    private Direction direction;
    private Pos pos;

    // Game stats
    private final int MAX_HP = 10;
    private final int STARTING_LIVES = 3;
    private int hp;
    private int lives;
    private boolean poweredDown;

    // Controllers
    private RobotViewController viewController;

    public Robot(Game game, int playerNumber) {
        hp = MAX_HP;
        lives = STARTING_LIVES;
        poweredDown = false;
        pos = game.getBoard().getRobotStartingPos(playerNumber);
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
        viewController = new RobotViewController(playerNumber, pos);
    }

    @Override
    public void move(int steps) {
        System.out.println("FROM Robot: I was told to a certain amount of steps");
        switch (direction) {
            case UP:
                pos.setY(steps);
                break;
            case DOWN:
                pos.setY(-steps);
                break;
            case RIGHT:
                pos.setX(steps);
                break;
            case LEFT:
                pos.setX(-steps);
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
        // TODO - if zer hp -> reboot robot on board, loose one life etc etc.
        hp--;
    }

    @Override
    public int getHP() {
        return hp;
    }


    public int livesLeft() {
        return lives;
    }

    public boolean isPoweredDown() {
        return poweredDown;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public RobotViewController getViewController() {
        return viewController;
    }
}
