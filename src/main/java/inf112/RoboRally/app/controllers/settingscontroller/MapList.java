package inf112.RoboRally.app.controllers.settingscontroller;

import inf112.RoboRally.app.models.board.*;

/*
Class that holds all the currently supported maps
 */
public class MapList {

    public final String PATH = "Boards/";

    private Board[] maps = {
            new VaultAssault(PATH),
            new Checkmate(PATH),
            new ChopShopChallenge(PATH),
            new DizzyDash(PATH),
            new IslandKing(PATH),
            new RiskyExchange(PATH),
            new RobotStew(PATH),
            new Tricksy(PATH),
            new WhirlwindTour(PATH)
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
