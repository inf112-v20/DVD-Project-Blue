package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.models.game.Player;

public class OpponentHUDTable {

    private final int ROW_PADDING = 12;

    private Table opponentTable;
    private OpponentHUD[] huds;

    public OpponentHUDTable(GameCardController gameCardController) {
        opponentTable = new Table();
        opponentTable.left();
        opponentTable.setFillParent(true);
        int numberOfPlayers = gameCardController.numberOfPlayers();
        huds = new OpponentHUD[numberOfPlayers-1]; // -1 because human player is not opponent
        for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
            Player player = gameCardController.getPlayer(playerNumber);
            if (!player.equals(gameCardController.humanPlayer())) {
                huds[playerNumber-1] = new OpponentHUD(player);
                opponentTable.add(huds[playerNumber-1].opponentHudGroup());
                opponentTable.row().padTop(ROW_PADDING);
            }
        }
    }

    public Table getOpponentTable() {
        return opponentTable;
    }



}
