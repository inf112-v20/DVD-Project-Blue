package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.controllers.CardControllers.CardController;
import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.Board;

public class Game {

    // the board
    private TmxMapLoader mapLoader;
    private Board board;
    private TiledMap map;

    // the game
    Round round;

    // the players
    private Player[] players;
    private boolean playerHasWon = false;
    private boolean playersAreReady = false;

    // Controllers
    CardController cardController;

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

        // the game
        round = new Round();

        cardController = new CardController(players[0]); // player1 is given as human player for now
        phase();

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
        round.dealCards(players);
    }

    public CardController getCardController() {
        return cardController;
    }
}
