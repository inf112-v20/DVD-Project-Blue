package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;

public class NewGame {

    // the board
    private Board board;

    // game execution
    private Round round;

    // players
    private NewPlayer[] players;
    private NewPlayer humanPlayer; // player 1 is given as human player for now

    // controllers
    private GameCardController gameCardController;

    //MapLoader
    private TiledMapLoader tiledMapLoader;

    public NewGame(SinglePlayerSettingsController settings) {
        board = settings.getMap();
        players = new NewPlayer[settings.getPlayerCount()];
        for (int nPlayer = 0; nPlayer < settings.getPlayerCount(); nPlayer++)
            players[nPlayer] = new NewPlayer(this, nPlayer);
        humanPlayer = players[0];
        gameCardController = new GameCardController(this);
        round = new Round(this);
        round.dealCards();
    }

    public Board getBoard() {
        return board;
    }

    public NewPlayer[] players() {
        return players;
    }

    public GameCardController getGameCardController() {
        return gameCardController;
    }

    public NewPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public Round round() {
        return round;
    }

    public TiledMapLoader setUpMadLoader() {
        tiledMapLoader = new TiledMapLoader(board.tiledMapFile());
        return tiledMapLoader;
    }


}
