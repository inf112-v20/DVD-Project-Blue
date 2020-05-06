package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;

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

    // Elements on the board
    private BoardElements boardElements;

    // timer that counts down to round execution
    private Timer timer;

    public Game(SinglePlayerSettingsController settings) {
        board = settings.getMap();
        timer = new Timer(this);
        tiledMapLoader = new TiledMapLoader(board.tiledMapFile());
        boardElements = new BoardElements(tiledMapLoader);
        players = new Player[settings.getPlayerCount()];
        for (int nPlayer = 0; nPlayer < settings.getPlayerCount(); nPlayer++)
            players[nPlayer] = new Player(this, nPlayer);
        players[humanPlayerNumberChoice].setAsHumanPlayer();
        humanPlayer = players[humanPlayerNumberChoice];
        gameCardController = new GameCardController(this);
        
        round = new Round(this);
        startFirstRound();

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

    public void startFirstRound() {
        round.startNewRound();
        setupPlayerUIsNewGame();
    }


    public void newRound() {
        clearAllCards();
        round.startNewRound();
        setupPlayerUIForNewRound();
    }

    private void setupPlayerUIForNewRound() {
        for (Player player: players)
            player.setupUIForNewRound();
    }

    private void clearAllCards() {
        for (Player player: players) {
            player.clearAllCards();
        }
    }

    public void executeRound() {
        for (Player player: players) {
            player.setupCardsForRoundExecution();
        }
        round.executeRound(timer);
    }

    public void setupPlayerUIsNewGame() {
        for (Player player: players) {
            player.setupUI();
        }
    }

    public BoardElements getBoardElements() {
        return boardElements;
    }

    public Timer getTimer() {
        return timer;
    }
}
