package inf112.RoboRally.app.views;

import inf112.RoboRally.app.views.Boards.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class MapList {

    private IBoard[] maps = {
            new VaultAssault(),
            new Checkmate()
    };

    //maps
    private VaultAssault vaultAssault = new VaultAssault();
    private Checkmate checkmate = new Checkmate();
    private ChopShopChallenge chopShopChallenge = new ChopShopChallenge();
    private DizzyDash dizzyDash = new DizzyDash();
    private IslandKing islandKing = new IslandKing();
    private RiskyExchange riskyExchange = new RiskyExchange();
    private RobotStew robotStew = new RobotStew();
    private Tricksy tricksy = new Tricksy();
    private WhirlwindTour whirlwindTour = new WhirlwindTour();

    private final static int mapCount = 9;
    private ArrayList<String> mapNames;
    private ArrayList<String> mapImages;
    private ListIterator mapNameIterator;
    private ListIterator mapPathIterator;
    private ListIterator mapImageIterator;

    public MapList() {
        mapNames = new ArrayList<String>(mapCount);
//        mapPaths = new ArrayList<String>(mapCount);
        mapImages = new ArrayList<String>(mapCount);

        mapNames.add(vaultAssault.getMapName());
//        mapPaths.add(vaultAssault.getFileName());
        mapImages.add(vaultAssault.getMapImage());

        mapNames.add(checkmate.getMapName());
//        mapPaths.add(checkmate.getFileName());
        mapImages.add(checkmate.getMapImage());

        mapNames.add(chopShopChallenge.getMapName());
//        mapPaths.add(chopShopChallenge.getFileName());
        mapImages.add(chopShopChallenge.getMapImage());

        mapNames.add(dizzyDash.getMapName());
//        mapPaths.add(dizzyDash.getFileName());
        mapImages.add(dizzyDash.getMapImage());

        mapNames.add(islandKing.getMapName());
//        mapPaths.add(islandKing.getFileName());
        mapImages.add(islandKing.getMapImage());

        mapNames.add(riskyExchange.getMapName());
//        mapPaths.add(riskyExchange.getFileName());
        mapImages.add(riskyExchange.getMapImage());

        mapNames.add(robotStew.getMapName());
//        mapPaths.add(robotStew.getFileName());
        mapImages.add(robotStew.getMapImage());

        mapNames.add(tricksy.getMapName());
//        mapPaths.add(tricksy.getFileName());
        mapImages.add(tricksy.getMapImage());

        mapNames.add(whirlwindTour.getMapName());
//        mapPaths.add(whirlwindTour.getFileName());
        mapImages.add(whirlwindTour.getMapImage());


        mapNameIterator = mapNames.listIterator();
//        mapPathIterator = mapPaths.listIterator();
        mapImageIterator = mapImages.listIterator();
    }

    public String getCurrentMapName () {
        if (!mapNameIterator.hasNext()) {
            mapNameIterator = mapNames.listIterator();
            return mapNameIterator.next().toString();
        }
        return mapNameIterator.next().toString();
    }

//    public String getCurrentMapPath () {
//        if (!mapPathIterator.hasNext()) {
//            mapPathIterator = mapPaths.listIterator();
//            return mapPathIterator.next().toString();
//        }
//        return mapPathIterator.next().toString();
//    }

    public String getCurrentMapImage () {
        if (!mapImageIterator.hasNext()) {
            mapImageIterator = mapImages.listIterator();
            return mapImageIterator.next().toString();
        }
        return mapImageIterator.next().toString();
    }

    public IBoard getMap(int mapNumber) {
        return maps[mapNumber];
    }
}
