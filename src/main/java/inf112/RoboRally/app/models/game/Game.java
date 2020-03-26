package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
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
    PlayerCardController playerCardController;

    public Game(SinglePlayerSettingsController settings) {

        // the board
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(settings.getMap().tiledMapFile());
        board = settings.getMap();

        // the players
        players = new Player[settings.getPlayerCount()];
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            players[i] = new Player(this, i+1);
        }
        humanPlayer = players[0];     // player1 is given as human player for now
        playerCardController = new PlayerCardController(humanPlayer);

        // the game executed
        round = new Round();
        round.dealCards(players);
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

    private void phase() {
        System.out.println(humanPlayer.readyForRound());
        if (humanPlayer.readyForRound()) {
            round.executeCardChoices(humanPlayer);
        }
        if (!playerHasWon) {
            round.dealCards(players);
        }
    }

    public PlayerCardController getPlayerCardController() {
        return playerCardController;
    }

    public boolean playerReady() {
        return humanPlayer.readyForRound();
    }
}
