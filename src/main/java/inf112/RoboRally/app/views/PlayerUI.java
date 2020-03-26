package inf112.RoboRally.app.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.views.CardView.CardView;

public class PlayerUI extends InputAdapter {

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;
    private CardView cardView;

    public PlayerUI (SpriteBatch spriteBatch, PlayerCardController cardController) {
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        stage = new Stage(viewport);
        playerHUD = new PlayerHUD(3, 9, false);
        cardView = new CardView(cardController);

        stage.addActor(playerHUD.create());
        stage.addActor(playerHUD.powerDown());
        stage.addActor(playerHUD.damageTokens());
        stage.addActor(playerHUD.lifeTokens());

        for (int slotNumber = 0; slotNumber < cardController.numberOfCardSlots(); slotNumber++)
            stage.addActor(cardView.getCardSlotTable(slotNumber));

        stage.addActor(cardView.getReceivedCardsTable());
        Gdx.input.setInputProcessor(cardView);
    }

    public Stage getStage () {
        return stage;
    }

    public void dispose() {
        stage.dispose();
    }
}
