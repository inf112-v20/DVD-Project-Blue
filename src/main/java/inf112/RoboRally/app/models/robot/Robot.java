package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;
import inf112.RoboRally.app.models.game.boardelements.flag.FlagType;
import inf112.RoboRally.app.models.game.boardelements.repair.RepairType;

public class Robot implements IRobot {

    private Player player;

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
    private boolean isDead;
    private boolean hasWon = false;
    private int flagsCaptured = 0;

    // View controllers
    private RobotViewController robotViewController;

    // Board elements for robot interaction
    private BoardElements boardElements;

    public Robot(Player player, Game game) {
        this.player = player;
        hp = MAX_HP;
        lives = STARTING_LIVES;
        poweredDown = false;
        isDead = false;
        pos = game.getBoard().getRobotStartingPos(player.getPlayerNumber());
        START_DIRECTION = game.getBoard().getRobotStartingDirection(player.getPlayerNumber());
        direction = game.getBoard().getRobotStartingDirection(player.getPlayerNumber());
        robotViewController = new RobotViewController(player.getPlayerNumber(), pos, direction);
        boardElements = game.getBoardElements();
    }


    @Override
    public void move(int steps) {

        if (boardElements.getWall().ACTIVE)
            steps = boardElements.getWall().effectRobot(positionClone(), direction, steps);
        if (boardElements.getCornerWall().ACTIVE)
            steps = boardElements.getCornerWall().effectRobot(positionClone(), direction, steps);
        if (boardElements.getHole().ACTIVE)
            steps = boardElements.getHole().effectRobotSteps(positionClone(), direction, steps);
        if (boardElements.getMapBounds().ACTIVE)
            steps = boardElements.getMapBounds().effectRobotSteps(positionClone(), direction, steps);

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
    public void looseHP(int hpToLoose) {
        hp -= hpToLoose;
        if (hp <= 0) reset(true);
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

    public void touchFlag(FlagType flag) {
        switch (flag) {
            case FIRST_FLAG:
                if (flagsCaptured == 0) {
                    flagsCaptured++;
                    robotViewController.touchedFlag();
                    System.out.println("Robot now has one flag");
                }
                pos.setNewRestartPos(pos.getX(), pos.getY());
                break;
            case SECOND_FLAG:
                if (flagsCaptured == 1) {
                    flagsCaptured++;
                    robotViewController.touchedFlag();
                }
                pos.setNewRestartPos(pos.getX(), pos.getY());
                System.out.println("touched second flag");
                break;
            case THIRD_FLAG:
                if (flagsCaptured == 2) {
                    flagsCaptured++;
                    hasWon = true;
                    robotViewController.hasWon();
                    System.out.println("We have a winner");
                }
                pos.setNewRestartPos(pos.getX(), pos.getY());
                break;
        }
    }


    // used when robot is dead
    public void reset(boolean looseLife) {
        if (looseLife) {
            lives--;
            isDead = true;
            robotViewController.updateViewToDead();
        }
        hp = getMAX_HP();
        player.clearCardSlots();
        pos.restart();
        robotViewController.updateXCord(pos.getX());
        robotViewController.updateYCord(pos.getY());
    }


    public void setAlive() {
        robotViewController.updateViewToAlive();
    }

    public void repair(RepairType repair) {
        switch (repair) {
            case WRENCH:
                hp = Math.max(MAX_HP, hp++); // discard three damage tokens
            case WRENCH_AND_HAMMER:
                hp = Math.max(MAX_HP, hp += 2); // discard two damage tokens
        }
        pos.setNewRestartPos(pos.getX(), pos.getY());
    }

    public boolean isDead() {
        return isDead;
    }

    public void changePowerDown(boolean poweredDown, boolean gainLife) {
        this.poweredDown = poweredDown;
        if (gainLife) lives = Math.min(STARTING_LIVES, lives += 1);
        if (poweredDown) robotViewController.updateViewPoweredDown(true);
        else             robotViewController.updateViewPoweredDown(false);
    }
}
