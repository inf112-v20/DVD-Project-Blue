package inf112.RoboRally.app.models.robot;

import inf112.RoboRally.app.controllers.RobotViewController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RobotStepMoveExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Pos pos;
    private Direction direction;
    private RobotViewController viewController;
    private AtomicInteger numberOfSteps;
    private AtomicInteger stepNumber;
    private final int CELLS_TO_MOVE;

    public RobotStepMoveExecutor(Robot robot, int numberOfSteps) {
        pos = robot.position();
        direction = robot.direction();
        viewController = robot.getViewController();
        stepNumber = new AtomicInteger(0);

        // moving backwards
        if (numberOfSteps < 0) {
            CELLS_TO_MOVE = -1;
            this.numberOfSteps = new AtomicInteger(-numberOfSteps);

            // moving forwards
        } else {
            CELLS_TO_MOVE = 1;
            this.numberOfSteps = new AtomicInteger(numberOfSteps);
        }

    }

    public void move() {
        final Runnable mover = () -> {
            switch (direction) {
                case RIGHT:
                    pos.moveHorizontal(CELLS_TO_MOVE);
                    break;
                case LEFT:
                    pos.moveHorizontal(-CELLS_TO_MOVE);
                    break;
                case UP:
                    pos.moveVertical(CELLS_TO_MOVE);
                    break;
                case DOWN:
                    pos.moveVertical(-CELLS_TO_MOVE);
                    break;
                default:
                    throw new IllegalStateException("RobotMoveExecutor was told to move the robot in direction '"+direction+"', which is not supported");
            }
            viewController.updateRobotViewPosition(pos, direction);

            if (stepNumber.incrementAndGet() == numberOfSteps.get())
                scheduler.shutdown();
        };
        scheduler.scheduleAtFixedRate(mover, 1000, 500, TimeUnit.MILLISECONDS);
    }


}
