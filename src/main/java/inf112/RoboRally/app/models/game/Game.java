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
    private int humanPlayerNumberChoice = 0; // player1 hardcoded as human player for now
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
        players[humanPlayerNumberChoice].setAsHumanPlayer();
        humanPlayer = players[humanPlayerNumberChoice];
        gameCardController = new GameCardController(this);
        
        round = new Round(this);
        newRound();

        // playerUI needs to be set up after round is started, because round deals out cards etc.
        for (Player player: players) {
            player.setupUI();
        }
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

    public Player getPlayer(int playerNumber) {
        return players[playerNumber];
    }


    public void newRound() {
        round.startNewRound();
    }

    public void executeCardsChoices() {
        round.executeCardChoices();
    }



}
