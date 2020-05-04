package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;
import inf112.RoboRally.app.models.game.boardelements.flag.FlagType;

public class Robot implements IRobot {

    // Position
    private final Direction START_DIRECTION;
    private Direction direction;
    private volatile Pos pos;

    // Game stats
    private final int MAX_HP = 10;
    private final int STARTING_LIVES = 3;
    private int hp;
    private int lives;
    private boolean poweredDown;
    private boolean[] flagsTouched = new boolean[2]; // three flags must be touched
//    private int playerNumber;  // NOT NEEDED?

    // Controllers
    private RobotViewController robotViewController;

    // Board elements for robot interaction
    private BoardElements boardElements;

    public Robot(Game game, int playerNumber) {
        hp = MAX_HP;
        lives = STARTING_LIVES;
//        this.playerNumber = playerNumber;
        poweredDown = false;
        pos = game.getBoard().getRobotStartingPos(playerNumber);
        START_DIRECTION = game.getBoard().getRobotStartingDirection(playerNumber);
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
        robotViewController = new RobotViewController(playerNumber, pos, direction);
        boardElements = game.getBoardElements();
    }


    @Override
    public void move(int steps) {

        // updating steps in accordance with board element potentially blocking path
        if (boardElements.getWall().ACTIVE)
            steps = boardElements.getWall().effectRobot(positionClone(), direction, steps);
        if (boardElements.getCornerWall().ACTIVE)
            steps = boardElements.getCornerWall().effectRobot(positionClone(), direction, steps);
        if (boardElements.getHole().ACTIVE)
            steps = boardElements.getHole().effectRobot(positionClone(), direction, steps);

        switch (direction) {
            case UP:
                pos.setY(steps);
                robotViewController.updateYCord(pos.getY());
                break;
            case DOWN:
                pos.setY(-steps);
                robotViewController.updateYCord(pos.getY());
                break;
            case RIGHT:
                pos.setX(steps);
                robotViewController.updateXCord(pos.getX());
                break;
            case LEFT:
                pos.setX(-steps);
                robotViewController.updateXCord(pos.getX());
                break;
            default:
                throw new IllegalStateException("robot has direction '"+direction+"', which is supported");
        }
        if (boardElements.getHole().standingInHole(positionClone())) {
            pos.restart(); // restart to init position, as robot died
            direction = START_DIRECTION;
            robotViewController.updateXCord(pos.getX());
            robotViewController.updateYCord(pos.getY());
            robotViewController.updateDirection(START_DIRECTION);
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
        robotViewController.getRobotView().updateDirection(rotation);
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

    public RobotViewController getRobotViewController() {
        return robotViewController;
    }

    public Pos positionClone() {
        return new Pos(pos.getX(), pos.getY());
    }


    public void moveOneStepInDirection(Direction direction) {
        switch (direction) {
            case DOWN:
                pos.setY(-1);
                robotViewController.updateYCord(pos.getY());
                break;
            case UP:
                pos.setY(1);
                robotViewController.updateYCord(pos.getY());
                break;
            case LEFT:
                pos.setX(-1);
                robotViewController.updateXCord(pos.getX());
                break;
            case RIGHT:
                pos.setX(1);
                robotViewController.updateXCord(pos.getX());
                break;
            default:
                throw new IllegalArgumentException("Robot is told to move in '"+direction+"', which is not supported");
        }
    }

    public void touchFlag(FlagType flag, int x, int y) {
        switch (flag) {
            case FIRST_FLAG:
                if (!flagsTouched[0]) {
                    flagsTouched[0] = true;
                    System.out.println("Robot now has one flag");
                }
                pos.setNewRestrtPos(x, y);
                break;
            case SECOND_FLAG:
                if (flagsTouched[0] && !flagsTouched[1]) {
                    flagsTouched[1] = true;

                }
                pos.setNewRestrtPos(x, y);
                System.out.println("touched second flag");
                break;
            case THIRD_FLAG:
                if (flagsTouched[1] && !flagsTouched[2]) {
                    flagsTouched[2] = true; // we have a winner
                    System.out.println("We have a winner");
                }
                pos.setNewRestrtPos(x, y);
                break;
        }
    }



}
