package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;

public class Game {

    // the board
    private TmxMapLoader mapLoader;
    private Board board;
    private TiledMap map;

    // game execution
    Round round;

    // players
    private Player[] players;
    private Player humanPlayer;
    private boolean playerHasWon;

    // Controllers
    GameCardController gameCardController;

    public Game(SinglePlayerSettingsController settings) {

        // the board
        mapLoader = new TmxMapLoader();
        System.out.println("The file: "+settings.getMap().tiledMapFile());
        map = mapLoader.load(settings.getMap().tiledMapFile());
        board = settings.getMap();

        // the players
        players = new Player[settings.getPlayerCount()];
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            players[i] = new Player(this, i);
        }
        humanPlayer = players[0]; // player1 is given as human player for now
        gameCardController = new GameCardController(this);
//        round = new Round(players, humanPlayer);
//        round.dealCards();

    }


    public TiledMap getMap () {
        return map;
    }


    public Board getBoard() {
        return board;
    }

    public Player[] players() {
        return players;
    }

    // TODO - implement
    private void phase() {
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
}
