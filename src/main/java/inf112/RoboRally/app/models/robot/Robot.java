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
    private int playerNumber;  // NOT NEEDED?

    // Controllers
    private RobotViewController viewController;

    public Robot(Game game, int playerNumber) {
        hp = MAX_HP;
        lives = STARTING_LIVES;
        this.playerNumber = playerNumber;
        poweredDown = false;
        pos = game.getBoard().getRobotStartingPos(playerNumber);
        direction = game.getBoard().getRobotStartingDirection(playerNumber);
        viewController = new RobotViewController(playerNumber, pos, direction);
    }


    @Override
    public void move(int steps) {

        // ROBOT blir gitt beskjed å bevege seg steps, en funksjon som sjekker for Wall må være her, og returnere riktig antall steps
        // kjør denne funksjonen her: checkWall(this (denne roboten), steps) (altså - ( checkWall(Robot robot, int steps) ))
        // funksjonen vil ligne på funksjonen du screenshotet meg
        // funksjonen vil prøve å la roboten gå  i retningen den peker
        // F.eks hvis den peker opp og skal gå 3 steps, og møter på en vegg ved siste step:
        // sjekk for vegg, hvis ikke gå et steg
        // sjekk for vegg, hvis ikke gå et steg
        // sjekk for vegg -> møter vegg: return 2 steps

        // sjekker retning -> gå steps i den retningen
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
//        System.out.println("FROM Robot: I was told to rotate");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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


    public void rotateDepr(Rotation rotation) {
        RobotRotateMoveExecutor robotRotateExecutor = new RobotRotateMoveExecutor(this, rotation);
        robotRotateExecutor.rotate();
        System.out.println("robot's direction = "+direction);
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
}
