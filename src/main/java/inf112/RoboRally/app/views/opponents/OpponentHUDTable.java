package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.models.game.Player;

public class OpponentHUDTable {

    private final int ROW_PADDING = 12;

    private Table opponentTable;
    private OpponentHUD[] huds;

    public OpponentHUDTable(Player player, GameCardController gameCardController, int slotNumberFacingUp) {
        opponentTable = new Table();
        opponentTable.left();
        opponentTable.setFillParent(true);
        int numberOfPlayers = gameCardController.numberOfPlayers();
        huds = new OpponentHUD[numberOfPlayers];
        for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
            Player opponentPlayer = gameCardController.getPlayer(playerNumber);
            if (!opponentPlayer.equals(player)) {
                if (slotNumberFacingUp != -1) System.out.println("Getting to OPPHUDTABLE, player"+player.getPlayerNumber());
                huds[playerNumber] = new OpponentHUD(opponentPlayer, slotNumberFacingUp);
                System.out.println(huds[playerNumber] == null);
                opponentTable.add(huds[playerNumber].opponentHudGroup());
                opponentTable.row().padTop(ROW_PADDING);
            }
        }
    }

    public Table getOpponentTable() {
        return opponentTable;
    }


    public void updateOppHudTable(boolean cardsFacingUp) {
        opponentTable = new Table();
        opponentTable.left();
        opponentTable.setFillParent(true);
        for (OpponentHUD hud: huds) {
            if (hud != null) {
                if (cardsFacingUp) hud.updateOpponentHUDCardsFacingUp();
//                opponentTable.add(hud.opponentHudGroup());
//                opponentTable.row().padTop(ROW_PADDING);
            }
        }
    }
}
