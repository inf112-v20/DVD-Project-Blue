package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.game.NewPlayer;
import inf112.RoboRally.app.models.robot.Robot;

public interface ICard {

    int priority();

    void moveRobot(Robot robot);

    String getFileName();

    void setPlayer(NewPlayer player);

    NewPlayer getPlayer();

}

