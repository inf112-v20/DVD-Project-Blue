package inf112.RoboRally.app.controllers.MapChoiceControllers;

import inf112.RoboRally.app.models.board.Board;

/*
Communicates map information to single player settings menu
 */
public class SinglePlayerSettingsController {

    public final int MIN_PLAYERS = 2;
    public final int INIT_MAP_CHOICE = 0; // index 0 in MapList, VaultAssault map.

    private int playerCount = MIN_PLAYERS;
    private int mapChoice = INIT_MAP_CHOICE;
    private MapList mapList = new MapList();
    private int maxPlayersOnCurrentMap = getMap().amountOfPlayerSupportedOnThisMap();

    public Board getMap() {
        return mapList.getMap(mapChoice);
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void chooseMap() {
        if (mapChoice < mapList.NUMBER_OF_MAPS) mapChoice++;
        else                mapChoice = INIT_MAP_CHOICE;

        // if we are choosing a map which supports fewer players
        maxPlayersOnCurrentMap = getMap().amountOfPlayerSupportedOnThisMap();
        if (playerCount > maxPlayersOnCurrentMap)
            playerCount = MIN_PLAYERS;
    }

    public int choosePlayerCount() {
        maxPlayersOnCurrentMap = getMap().amountOfPlayerSupportedOnThisMap();
        if (playerCount < maxPlayersOnCurrentMap) playerCount++;
        else                  playerCount = MIN_PLAYERS;
        return playerCount;
    }

    public void setPlayerCountTo1() {
        playerCount = 1;
    }

}
