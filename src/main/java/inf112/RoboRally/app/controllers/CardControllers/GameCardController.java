package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;

/*
Class that communicates relevant game stats in terms of cards to view, and slot choices
from the view to the model player class
 */
public class GameCardController {

    private Player[] players;
    private static int numberOfPlayers;
    private static Game game;

    public GameCardController(Game game) {
        this.game = game;
        this.players = game.players();
        numberOfPlayers = players.length;
    }




    public Player[] players() {
        return players;
    }

    public static int numberOfPlayers() {
        return numberOfPlayers;
    }


}
