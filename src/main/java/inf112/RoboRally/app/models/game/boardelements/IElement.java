package inf112.RoboRally.app.models.game.boardelements;

import inf112.RoboRally.app.models.robot.Robot;

public interface IElement {

    int effectRobotSteps(int steps);

    void effectRobotAfterCardExec(Robot robot);

    boolean inEffectForSlotNumber(int slotNumber);

}
