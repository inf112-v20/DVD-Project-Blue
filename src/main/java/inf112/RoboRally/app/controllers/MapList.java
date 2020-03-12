package inf112.RoboRally.app.controllers;

import inf112.RoboRally.app.views.Boards.*;

public class MapList {

    private IBoard[] maps = {
            new VaultAssault(),
            new Checkmate(),
            new ChopShopChallenge(),
            new DizzyDash(),
            new IslandKing()
    };

    // starting from zero
    public final int NUMBER_OF_MAPS = maps.length-1;

    public IBoard getMap(int mapNumber) {
        if (mapNumber < 0 || mapNumber > maps.length -1) {
            throw new IllegalArgumentException("Map number '"+mapNumber+"' is not supported");
        }
        return maps[mapNumber];
    }
}
