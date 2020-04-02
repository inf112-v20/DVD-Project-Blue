package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;

public class Game {

    // the board
    private Board board;

    // game execution
    private Round round;

    // players
    private Player[] players;
    private Player humanPlayer; // player 1 is given as human player for now

    // controllers
    private GameCardController gameCardController;

    //MapLoader
    private TiledMapLoader tiledMapLoader;

    public Game(SinglePlayerSettingsController settings) {
        board = settings.getMap();
        tiledMapLoader = new TiledMapLoader(board.tiledMapFile());
        players = new Player[settings.getPlayerCount()];
        for (int nPlayer = 0; nPlayer < settings.getPlayerCount(); nPlayer++)
            players[nPlayer] = new Player(this, nPlayer);
        humanPlayer = players[0];
        gameCardController = new GameCardController(this);
        round = new Round(this);
        round.dealCards();
    }

    public Board getBoard() {
        return board;
    }

    public Player[] players() {
        return players;
    }

    public GameCardController getGameCardController() {
        return gameCardController;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Round round() {
        return round;
    }

    public TiledMapLoader setUpMadLoader() {
        return tiledMapLoader;
    }


}
