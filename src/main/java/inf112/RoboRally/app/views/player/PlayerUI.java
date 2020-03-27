package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.views.card.GameScreenCards;
import inf112.RoboRally.app.views.menus.Button;

public class PlayerUI extends InputAdapter {

    private Table cardViewTimer;
    private TextButton runButton;

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;
    private GameScreenCards gameScreenCards;
    private PlayerCardController playerCardController;

    public PlayerUI (PlayerCardController controller) {
        this.playerCardController = controller;
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        cardViewTimer = new Table();
        stage = new Stage(viewport);
        playerHUD = new PlayerHUD(3, 9, false); // connection to models between player health and lives not implemented
        gameScreenCards = new GameScreenCards(playerCardController);

        stage.addActor(playerHUD.create());
        stage.addActor(playerHUD.powerDown());
        stage.addActor(playerHUD.damageTokens());
        stage.addActor(playerHUD.lifeTokens());
        stage.addActor(cardViewTimer());

        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++)
            stage.addActor(gameScreenCards.getCardSlotTable(slotNumber));

        stage.addActor(gameScreenCards.getReceivedCardsTable());
        Gdx.input.setInputProcessor(gameScreenCards);
    }

    public Stage getStage () {
        return stage;
    }

    public void dispose() {
        stage.dispose();
    }


    public Table cardViewTimer() {

        cardViewTimer.pad(0, 3830, 250, 0);
        runButton = new Button().createTextButton("READY");

        cardViewTimer.row().padTop(20);
        cardViewTimer.add(runButton);

        runButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playerCardController.setCardSlotsFromUserInput(gameScreenCards.getCardChoices());
            }
        });

        return cardViewTimer;
    }
}
