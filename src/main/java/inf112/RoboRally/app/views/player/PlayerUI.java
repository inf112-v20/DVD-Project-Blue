package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.views.card.GameScreenCards;
import inf112.RoboRally.app.views.card.ICardDragAndDrop;

public class PlayerUI extends InputAdapter {

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;
    private GameScreenCards gameScreenCards;
    private boolean playerIsReady;

    public PlayerUI (PlayerCardController playerCardController) {
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        stage = new Stage(viewport);
        playerHUD = new PlayerHUD(3, 9, false); // connection to models between player health and lives not implemented
        gameScreenCards = new GameScreenCards(playerCardController);

        stage.addActor(playerHUD.create());
        stage.addActor(playerHUD.powerDown());
        stage.addActor(playerHUD.damageTokens());
        stage.addActor(playerHUD.lifeTokens());

        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++)
            stage.addActor(gameScreenCards.getCardSlotTable(slotNumber));

        stage.addActor(gameScreenCards.getReceivedCardsTable());
        Gdx.input.setInputProcessor(gameScreenCards);

        // communicating card choices back to model
        ICardDragAndDrop[] cardChoices = gameScreenCards.cardChoiceReady();
        if (cardChoices != null) playerCardController.setCardSlotsFromUserInput(cardChoices);
    }

    public Stage getStage () {
        return stage;
    }

    public void dispose() {
        stage.dispose();
    }

    public boolean playerIsReady() {
        return playerIsReady;
    }
}
