package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;

public interface ICard {

    int priority();

    void moveRobot(Robot robot);

}

