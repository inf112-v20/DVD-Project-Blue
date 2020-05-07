package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;
import inf112.RoboRally.app.models.game.boardelements.flag.FlagType;
import inf112.RoboRally.app.models.game.boardelements.repair.RepairType;

public class Robot implements IRobot {

    // Position
    private Direction direction;
    private volatile Pos pos;

    // Game stats
    private final int MAX_HP = 10;
    private final int MAX_LIVES = 3;
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

    public Robot(Pos startingPos, Direction startingDir) {
        hp = MAX_HP;
        lives = MAX_LIVES;
        poweredDown = false;
        isDead = false;
        pos = startingPos;
        direction = startingDir;
    }


    @Override
    public void move(int steps) {

        if (boardElements != null) {
            if (boardElements.getWall().ACTIVE)
                steps = boardElements.getWall().effectRobot(positionClone(), direction, steps);
            if (boardElements.getCornerWall().ACTIVE)
                steps = boardElements.getCornerWall().effectRobot(positionClone(), direction, steps);
            if (boardElements.getHole().ACTIVE)
                steps = boardElements.getHole().effectRobotSteps(positionClone(), direction, steps);
            if (boardElements.getMapBounds().ACTIVE)
                steps = boardElements.getMapBounds().effectRobotSteps(positionClone(), direction, steps);
        }

        switch (direction) {
            case UP:
                pos.updateY(steps);
                if (robotViewController != null) robotViewController.updateYCord(pos.getY());
                break;
            case DOWN:
                pos.updateY(-steps);
                if (robotViewController != null) robotViewController.updateYCord(pos.getY());
                break;
            case RIGHT:
                pos.updateX(steps);
                if (robotViewController != null) robotViewController.updateXCord(pos.getX());
                break;
            case LEFT:
                pos.updateX(-steps);
                if (robotViewController != null) robotViewController.updateXCord(pos.getX());
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
        if (robotViewController != null) robotViewController.getRobotView().updateDirection(rotation);
    }


    public Pos pos() {
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

    public void gainHP(int hpToGain) {
        hp = Math.min(hp += hpToGain, MAX_HP);
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
                pos.updateY(-1);
                if (robotViewController != null) robotViewController.updateYCord(pos.getY());
                break;
            case UP:
                pos.updateY(1);
                if (robotViewController != null) robotViewController.updateYCord(pos.getY());
                break;
            case LEFT:
                pos.updateX(-1);
                if (robotViewController != null) robotViewController.updateXCord(pos.getX());
                break;
            case RIGHT:
                pos.updateX(1);
                if (robotViewController != null) robotViewController.updateXCord(pos.getX());
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
                    if (robotViewController != null) robotViewController.touchedFlag();
                }
                gainHP(1);
                pos.setNewRestartPos(pos.getX(), pos.getY());
                break;
            case SECOND_FLAG:
                if (flagsCaptured == 1) {
                    flagsCaptured++;
                    if (robotViewController != null) robotViewController.touchedFlag();
                }
                gainHP(1);
                pos.setNewRestartPos(pos.getX(), pos.getY());
                break;
            case THIRD_FLAG:
                if (flagsCaptured == 2) {
                    flagsCaptured++;
                    hasWon = true;
                    if (robotViewController != null) robotViewController.hasWon();
                }
                gainHP(1);
                pos.setNewRestartPos(pos.getX(), pos.getY());
                break;
        }
    }


    public void reset(boolean looseLife) {
        if (looseLife) {
            lives--;
            isDead = true;
            if (robotViewController != null)
                robotViewController.updateViewToDead();
        }
        if (lives > 0) {

            hp = getMAX_HP();
            pos.restart();
            if (robotViewController != null) {
                robotViewController.updateXCord(pos.getX());
                robotViewController.updateYCord(pos.getY());
            }

        }

    }


    public void setAlive() {
        robotViewController.updateViewToAlive();
    }

    public void repair(RepairType repair) {
        switch (repair) {
            case WRENCH:
                gainHP(1);
                break;
            case WRENCH_AND_HAMMER:
                gainHP(2);
                break;
        }
        pos.setNewRestartPos(pos.getX(), pos.getY());
    }

    public boolean isDead() {
        return isDead;
    }

    public void changePowerDown(boolean poweredDown, boolean gainLife) {
        this.poweredDown = poweredDown;
        if (gainLife) lives = Math.min(MAX_LIVES, lives += 1);
        if (poweredDown) {
            if (robotViewController != null) robotViewController.updateViewPoweredDown(true);
        }
        else            {
            if (robotViewController != null) robotViewController.updateViewPoweredDown(false);
        }
    }

    public boolean isWinner() {
        return hasWon;
    }

    public void setupRobotViewController(int playerNumber) {
        robotViewController = new RobotViewController(playerNumber, pos, direction);
    }

    public void communicateBoardElements(BoardElements boardElements) {
        this.boardElements = boardElements;
    }

    public int flagsCaptured() {
        return flagsCaptured;
    }
}
