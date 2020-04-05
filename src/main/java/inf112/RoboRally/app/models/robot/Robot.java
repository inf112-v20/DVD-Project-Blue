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
        viewController = new RobotViewController(playerNumber, pos, direction);
    }


    @Override
    public void move(int steps) {
        // uses a Runnable to execute moves in time specified increments
        RobotMoveExecutor robotMoveExecutor = new RobotMoveExecutor(this, steps);
        robotMoveExecutor.move();

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
                throw new IllegalArgumentException("Robot is told to rotate '"+rotation+"', which is not supported");
        }
        viewController.updateRobotViewPosition(pos, direction);
    }

    public Pos position() {
        return pos;
    }

    public Direction direction() {
        return direction;
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
