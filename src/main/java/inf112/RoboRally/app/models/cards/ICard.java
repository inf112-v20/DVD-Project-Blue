package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.game.Player;

public interface ICard {

    int priority();

    void moveRobot();

    String getFileName();

    void setPlayer(Player player);

    Player getPlayer();

}

