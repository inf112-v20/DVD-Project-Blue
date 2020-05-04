package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;

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
    private int playerNumber;  // NOT NEEDED?

    // Controllers
    private RobotViewController viewController;

    // Board elements for robot interaction
    private BoardElements boardElements;

    public Robot(Game game, int playerNumber) {
        hp = MAX_HP;
        lives = STARTING_LIVES;
        this.playerNumber = playerNumber;
        poweredDown = false;
        pos = game.getBoard().getRobotStartingPos(playerNumber);
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
        viewController = new RobotViewController(playerNumber, pos, direction);
        boardElements = game.getBoardElements();
    }


    @Override
    public void move(int steps) {

        // updating steps if a wall is blocking path
        steps = boardElements.getWall().effectRobot(positionClone(), direction, steps);
        steps = boardElements.getCornerWall().effectRobot(positionClone(), direction, steps);

        switch (direction) {
            case UP:
                pos.setY(steps); // her settes endelig posisjon
                viewController.getRobotView().updateY(pos.getY()); // den endelige posisjonen gis til robotview
                break;
            case DOWN:
                pos.setY(-steps);
                viewController.getRobotView().updateY(pos.getY());
                break;
            case RIGHT:
                pos.setX(steps);
                viewController.getRobotView().updateX(pos.getX());
                break;
            case LEFT:
                pos.setX(-steps);
                viewController.getRobotView().updateX(pos.getX());
                break;
            default:
                throw new IllegalStateException("robot has direction '"+direction+"', which is supported");
        }

    }

    @Override
    public void rotate(Rotation rotation) {

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
        viewController.getRobotView().updateDirection(rotation);
    }


    public Pos position() {
        return pos;
    }

    public Direction direction() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public Pos positionClone() {
        return new Pos(pos.getX(), pos.getY());
    }


}
