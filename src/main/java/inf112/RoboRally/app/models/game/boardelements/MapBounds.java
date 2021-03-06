package inf112.RoboRally.app.models.game.boardelements;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class MapBounds implements IRegistrationPhaseElement {

    private final int Y_LOWER_BOUND = 2;
    private final int Y_UPPER_BOUND = 15;
    private final int X_LOWER_BOUND = 4;
    private final int X_UPPER_BOUND = 21;
    public final boolean ACTIVE = true;


    @Override
    public void effectRobotInRegistrationPhase(Robot robot) {
        Pos pos = robot.pos();
        if (checkForYBound(pos.getY()) || checkForXBound(pos.getX())) robot.reset(true);
    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return ACTIVE;
    }


    public int effectRobotSteps(Pos pos, Direction direction, int steps) {
        switch (direction) {
            case UP:
                return checkForBoundMovingUp(pos, steps);
            case DOWN:
                return checkForBoundMovingDown(pos, steps);
            case RIGHT:
                return checkForBoundMovingRight(pos, steps);
            case LEFT:
                return checkForBoundMovingLeft(pos, steps);
            default:
                throw new IllegalStateException("Robot has direction '"+direction+"', which is not supported");
        }
    }


    private int checkForBoundMovingLeft(Pos pos, int steps) {
        for (int step = 1; step <= steps; step++) {
            pos.updateX(-1);
            if (checkForXBound(pos.getX())) return step;
        }
        return steps;
    }

    private boolean checkForXBound(int x) {
        return x <= X_LOWER_BOUND || x >= X_UPPER_BOUND;
    }

    private int checkForBoundMovingRight(Pos pos, int steps) {
        for (int step = 1; step <= steps; step++) {
            pos.updateX(1);
            if (checkForXBound(pos.getX())) return step;
        }
        return steps;
    }

    private int checkForBoundMovingDown(Pos pos, int steps) {
        for (int step = 1; step <= steps; step++) {
            pos.updateY(-1);
            if (checkForYBound(pos.getY())) return step;
        }
        return steps;
    }

    private boolean checkForYBound(int y) {
        return y <= Y_LOWER_BOUND || y >= Y_UPPER_BOUND;
    }

    private int checkForBoundMovingUp(Pos pos, int steps) {
        for (int step = 1; step <= steps; step++) {
            pos.updateY(1);
            if (checkForYBound(pos.getY())) return step;
        }
        return steps;
    }


}
