package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.board.Direction;
import inf112.RoboRally.app.models.board.Position;
import inf112.RoboRally.app.models.board.Robot;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.views.PlayerHUD;

/*
Class that holds information about each player. Initialized with
starting position and direction for the players' robot, as passed by the being
played on.
 */
public class Player {

    private String name;
    private Robot robot;
    private PlayerHUD hud;
    private int playerNumber;
    private ICard[] cardsToChose;
    private ICard[] cardsChosen;

    public Player(Position pos, Direction direction, int playerNumber) {
//        robot = new Robot(pos, direction);
//        this.playerNumber = playerNumber;
    }

    public Robot getRobot() {
        return robot;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
