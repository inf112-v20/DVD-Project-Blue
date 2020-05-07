package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;
import inf112.RoboRally.app.models.game.boardelements.BoardElements;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.models.robot.Robot;

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

        // setting up the board
        board = settings.getMap();
        tiledMapLoader = new TiledMapLoader(board.tiledMapFile());
        timer = new Timer(this);
        boardElements = new BoardElements(tiledMapLoader);

        // setting up players
        players = new Player[settings.getPlayerCount()];
        for (int playerNumber = 0; playerNumber < settings.getPlayerCount(); playerNumber++) {
            Pos startingPos = board.getRobotStartingPos(playerNumber);
            Direction startingDir = board.getRobotStartingDirection(playerNumber);
            players[playerNumber] = new Player(playerNumber, startingPos, startingDir);
        }

        // opponent players must be known to each player in order to set up opponentHuds
        // opponent players are only known after each player have been initialized
        for (Player player: players) {
            player.setOpponentPlayers(players);
            player.setupBoardElements(boardElements);
            player.setupRobotView();
        }

        players[humanPlayerNumberChoice].setAsHumanPlayer();
        humanPlayer = players[humanPlayerNumberChoice];

        boardElements.setupRobotShootOtherRobotChecker(allRobotsInGame());

        // starting the game
        gameCardController = new GameCardController(this);
        round = new Round(players);
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
        round.dealCardsAndBotsChooseCards();
        setupPlayerUIsNewRound();
    }


    public void newRound() {
        resetPlayerCards();
        round.dealCardsAndBotsChooseCards();
        setupPlayerUIsNewRound();
        giveReceivedCardsToPlayersForNewRound();
    }

    private void giveReceivedCardsToPlayersForNewRound() {
        for (Player player: players)
            player.getPlayerUI().getReceivedCardsForThisRound();
    }

    private void resetPlayerCards() {
        for (Player player: players)
            player.resetCards();
    }



    private void updateOpponentHUDCardSlots() {
        for (Player player: players)
            player.updateOpponentCardSlots(true);
    }


    public void executeRound() {
        for (Player player: players) {
            player.setupCardsForRoundExecution();
        }
        updateOpponentHUDCardSlots();
        round.executeRound(timer, boardElements.boardEffects());
    }

    public void setupPlayerUIsNewRound() {
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


    private Robot[] allRobotsInGame() {
        Robot[] robots = new Robot[players.length];
        for (int playerNumber = 0; playerNumber < robots.length; playerNumber++) {
            robots[playerNumber] = players[playerNumber].robot();
        }
        return robots;
    }


}
