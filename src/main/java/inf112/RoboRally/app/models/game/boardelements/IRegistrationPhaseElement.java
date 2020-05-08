package inf112.RoboRally.app.models.game.boardelements;

import inf112.RoboRally.app.models.robot.Robot;

public interface IRegistrationPhaseElement {

    void effectRobotInRegistrationPhase(Robot robot);

    boolean inEffectForSlotNumber(int slotNumber);

}
