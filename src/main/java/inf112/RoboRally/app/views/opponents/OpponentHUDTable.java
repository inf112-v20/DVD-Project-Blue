package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.models.game.Player;

public class OpponentHUDTable {

    private final int ROW_PADDING = 12;
    private final int LEFT_PADDING = 32;

    private Table opponentTable;
    private OpponentHUD[] huds;

    public OpponentHUDTable(Player player, boolean cardsFacingUp) {
        opponentTable = new Table();
        opponentTable.left().padLeft(LEFT_PADDING);
        opponentTable.setFillParent(true);
        int numberOfPlayers = player.getNumberOfPlayersInGame();
        huds = new OpponentHUD[numberOfPlayers];
        for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
            Player opponentPlayer = player.getGame().getPlayer(playerNumber);
            if (!opponentPlayer.equals(player)) {
                huds[playerNumber] = new OpponentHUD(opponentPlayer, cardsFacingUp);
                opponentTable.add(huds[playerNumber].opponentHudGroup());
                opponentTable.row().padTop(ROW_PADDING);
            }
        }
    }

    public Table getOpponentTable() {
        return opponentTable;
    }



}
