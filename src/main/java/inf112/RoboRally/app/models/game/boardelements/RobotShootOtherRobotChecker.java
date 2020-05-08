package inf112.RoboRally.app.models.game.boardelements;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class RobotShootOtherRobotChecker implements IRegistrationPhaseElement {

    private Robot[] robots;

    @Override
    public void effectRobotInRegistrationPhase(Robot robot) {
        Pos robotPos = robot.pos();

        for (Robot enemyRobot: robots) {

            // the robot cant shoot itself, and the shooting robot cannot be powered down or dead
            if (!enemyRobot.equals(robot) && !enemyRobot.isPoweredDown() && !enemyRobot.isDead()) {
               Pos enemyRobotPos = enemyRobot.pos();

               if (enemyRobotPos.getX() == robotPos.getX()) {

                   // enemyRobot is directly above robot and looking down -> enemyRobot shoots robot
                   if (enemyRobotPos.getY() > robotPos.getY() && enemyRobot.direction() == Direction.DOWN) {
                       robot.looseHP(1);
                   }

                   // enemyRobot is directly below robot and looking up -> enemyRobot shoots robot
                   else if (enemyRobotPos.getY() < robotPos.getY() && enemyRobot.direction() == Direction.UP) {
                       robot.looseHP(1);
                   }
               }
               else if ( enemyRobotPos.getY() == robotPos.getY() ) {

                   // enemyRobot is directly to the left of robot and looking right -> enemyRobot shoots robot
                   if (enemyRobotPos.getX() < robotPos.getX() && enemyRobot.direction() == Direction.RIGHT ) {
                       robot.looseHP(1);
                   }

                   // enemyRobot is directly to the right of robot and looking left -> enemyRobot shoots robot
                   else if (enemyRobotPos.getX() > robotPos.getX() && enemyRobot.direction() == Direction.LEFT) {
                       robot.looseHP(1);
                   }


               }
            }


        }


    }

    @Override
    public boolean inEffectForSlotNumber(int slotNumber) {
        return true;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }
}
