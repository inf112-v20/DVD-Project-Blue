package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.RoboRally.app.controllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.views.Boards.IBoard;

public class Game {

    // the board
    private TmxMapLoader mapLoader;
    private IBoard board;
    private TiledMap map;

    // the game
    Round round;

    // the players
    private Player[] players = new Player[8];
    private boolean playerHasWon = false;
    private boolean playersAreReady = false;

    public Game(SinglePlayerSettingsController settings) {
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(settings.getMap().getFilePath());
        board = settings.getMap();
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            players[i] = new Player(this, i+1);
        }
    }

    public TiledMap getMap () {
        return map;
    }

    public IBoard getBoard() {
        return board;
    }

    public Player[] players() {
        return players;
    }

    private void phase() {
        round.dealCards(players);
        if (playersAreReady) { // or time is out
            round.executeAllCardChoices(players);
        }
    }
}
