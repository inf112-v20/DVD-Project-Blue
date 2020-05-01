package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;
import inf112.RoboRally.app.models.cards.Rotation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RobotRotateMoveExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Pos pos;
    private Direction direction;
    private Rotation rotation;
    private RobotViewController viewController;
    private Robot robot;

    public RobotRotateMoveExecutor(Robot robot, Rotation rotation) {
        direction = robot.direction();
        pos = robot.position();
        this.rotation = rotation;
        this.robot = robot;
        viewController = robot.getViewController();
    }

    public void rotate() {
        final Runnable rotator = () -> {
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
                    throw new IllegalArgumentException("Robot was told to rotate '"+rotation+"', which is not supported");
            }
            robot.setDirection(direction);
//            viewController.updateRobotViewPosition(pos, direction);
            scheduler.shutdown();
        };
        scheduler.scheduleAtFixedRate(rotator, 1000, 500, TimeUnit.MILLISECONDS);
    }

}
