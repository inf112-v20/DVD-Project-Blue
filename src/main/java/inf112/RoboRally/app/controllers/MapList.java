package inf112.RoboRally.app.controllers;

import inf112.RoboRally.app.models.board.*;

public class MapList {

    public final String PATH = "Boards/";

    private Board[] maps = {
            new VaultAssault(PATH),
            new Checkmate(PATH),
            new ChopShopChallenge(PATH),
            new DizzyDash(PATH),
            new IslandKing(PATH)
    };

    // starting from zero
    public final int NUMBER_OF_MAPS = maps.length-1;

    public Board getMap(int mapNumber) {
        if (mapNumber < 0 || mapNumber > maps.length -1) {
            throw new IllegalArgumentException("Map number '"+mapNumber+"' is not supported");
        }
        return maps[mapNumber];
    }

}
