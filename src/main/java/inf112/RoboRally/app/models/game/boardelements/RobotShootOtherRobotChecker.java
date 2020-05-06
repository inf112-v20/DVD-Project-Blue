package inf112.RoboRally.app.models.game.boardelements;

import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

public class RobotShootOtherRobotChecker implements IElement {

    private Robot[] robots;

    public RobotShootOtherRobotChecker() {}

    @Override
    public int effectRobotSteps(int steps) {
        return 0;
    }

    @Override
    public void effectRobotAfterCardExec(Robot robot) {
        Pos robotPos = robot.position();

        robot.getRobotViewController().timeToShoot(true);

        for (Robot enemyRobot: robots) {

            // the robot cant shoot itself, and the shooting robot cannot be powered down
            if (!enemyRobot.equals(robot) && !enemyRobot.isPoweredDown()) {
               Pos enemyRobotPos = enemyRobot.position();

               if (enemyRobotPos.getX() == robotPos.getX()) {

                   // enemyRobot is directly above robot and looking down -> enemyRobot shoots robot
                   if (enemyRobotPos.getY() > robotPos.getY() && enemyRobot.direction() == Direction.DOWN) {
                       System.out.println("robot got shot");
                       robot.looseHP(1);
                   }

                   // enemyRobot is directly below robot and looking up -> enemyRobot shoots robot
                   else if (enemyRobotPos.getY() < robotPos.getY() && enemyRobot.direction() == Direction.UP) {
                       System.out.println("robot got shot");
                       robot.looseHP(1);
                   }
               }
               else if ( enemyRobotPos.getY() == robotPos.getY() ) {

                   // enemyRobot is directly to the left of robot and looking right -> enemyRobot shoots robot
                   if (enemyRobotPos.getX() < robotPos.getX() && enemyRobot.direction() == Direction.RIGHT ) {
                       System.out.println("robot got shot");
                       robot.looseHP(1);
                   }

                   // enemyRobot is directly to the right of robot and looking left -> enemyRobot shoots robot
                   else if (enemyRobotPos.getX() > robotPos.getX() && enemyRobot.direction() == Direction.LEFT) {
                       System.out.println("robot got shot");
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
