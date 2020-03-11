package inf112.RoboRally.app.controllers;

import inf112.RoboRally.app.views.Boards.IBoard;

public class SinglePlayerSettingsController {

    private int playerCount = 2;
    private int mapChoice = 0;
    private MapList mapList = new MapList();

    public IBoard getMap() {
        return mapList.getMap(mapChoice);
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void chooseMap() {
        if (mapChoice < 2) mapChoice++;
        else                mapChoice = 0;
    }

    public int choosePlayerCount() {
        if (playerCount < 8) playerCount++;
        else                  playerCount = 2;
        return playerCount;
    }
}
