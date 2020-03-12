package inf112.RoboRally.app.controllers;

import inf112.RoboRally.app.views.Boards.IBoard;

public class SinglePlayerSettingsController {

    public final int MIN_PLAYERS = 2;
    public final int INIT_MAP_CHOICE = 0;

    private int playerCount = MIN_PLAYERS;
    private int mapChoice = INIT_MAP_CHOICE;
    private MapList mapList = new MapList();
    private int maxPlayersOnCurrentMap = getMap().amountOfPlayersSupported();

    public IBoard getMap() {
        return mapList.getMap(mapChoice);
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void chooseMap() {
        if (mapChoice < mapList.NUMBER_OF_MAPS) mapChoice++;
        else                mapChoice = INIT_MAP_CHOICE;

        // if we are choosing a map which supports fewer players
        maxPlayersOnCurrentMap = getMap().amountOfPlayersSupported();
        if (playerCount > maxPlayersOnCurrentMap)
            playerCount = MIN_PLAYERS;
    }

    public int choosePlayerCount() {
        maxPlayersOnCurrentMap = getMap().amountOfPlayersSupported();
        if (playerCount < maxPlayersOnCurrentMap) playerCount++;
        else                  playerCount = MIN_PLAYERS;
        return playerCount;
    }
}
