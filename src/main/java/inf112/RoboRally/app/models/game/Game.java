package inf112.RoboRally.app.models.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
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

    //MAP LAYER//
    private TiledMapTileLayer wallLayer;
    private TiledMapTileLayer doubleWallLayer;
    private TiledMapTileLayer pusherLayer;
    //MAP LAYER//

    public Game(SinglePlayerSettingsController settings) {

        // the board
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(settings.getMap().tiledMapFile());
        board = settings.getMap();

        //MAP LAYER//
        wallLayer = (TiledMapTileLayer) map.getLayers().get("wall");
        doubleWallLayer = (TiledMapTileLayer) map.getLayers().get("doubleWall");
        pusherLayer = (TiledMapTileLayer) map.getLayers().get("pusher");
        //MAP LAYER//

        // the players
        players = new Player[settings.getPlayerCount()];
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            players[i] = new Player(this, i);
        }
        humanPlayer = players[0]; // player1 is given as human player for now
        gameCardController = new GameCardController(this);
        round = new Round(players, humanPlayer);
        round.dealCards();

    }

    // constructor without maploader for testing purposes
    public Game() {
        SinglePlayerSettingsController settings = new SinglePlayerSettingsController();
        settings.choosePlayerCount();
        settings.choosePlayerCount();
        board = settings.getMap();
        players = new Player[settings.getPlayerCount()];
        for (int i = 0; i < settings.getPlayerCount(); i++) {
            players[i] = new Player(this, i);
        }
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

    public boolean playerReady() {
        return humanPlayer.readyForRound();
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Round round() {
        return round;
    }


    //MAP LAYER//
    public TiledMapTileLayer getWallLayer() {
        return wallLayer;
    }

    public TiledMapTileLayer.Cell getWallLayerCell(int x, int y) {
        return wallLayer.getCell(x, y);
    }

    public TiledMapTileLayer getDoubleWallLayer() {
        return doubleWallLayer;
    }

    public TiledMapTileLayer.Cell getDoubleWallLayerCell(int x, int y) {
        return doubleWallLayer.getCell(x, y);
    }

    public TiledMapTileLayer getPusherLayer() {
        return pusherLayer;
    }

    public TiledMapTileLayer.Cell getPusherLayerCell(int x, int y) {
        return pusherLayer.getCell(x, y);
    }
    //MAP LAYER//
}
