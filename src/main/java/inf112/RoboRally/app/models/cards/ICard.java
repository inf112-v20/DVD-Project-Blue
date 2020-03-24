package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.Robot.Robot;

public interface ICard {

    int priority();

    void moveRobot(Robot robot);

    void setPriority(int priority);

    String getFileName();

}

