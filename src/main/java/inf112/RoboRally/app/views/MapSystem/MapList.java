package inf112.RoboRally.app.views.MapSystem;

import inf112.RoboRally.app.views.Boards.Checkmate;
import inf112.RoboRally.app.views.Boards.IBoard;
import inf112.RoboRally.app.views.Boards.VaultAssault;

public class MapList {

    private IBoard[] maps = {
            new VaultAssault(),
            new Checkmate()
    };

    public IBoard getMap(int mapNumber) {
        if (mapNumber < 0 || mapNumber > maps.length -1) {
            throw new IllegalArgumentException("Map number '"+mapNumber+"' is not supported");
        }
        return maps[mapNumber];
    }
}
