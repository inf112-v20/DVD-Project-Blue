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
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.views.card.GameScreenCards;
import inf112.RoboRally.app.views.menus.Button;

public class PlayerUI extends InputAdapter {

    private Table cardViewTimer;
    private TextButton readyButton;

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;
    private GameScreenCards gameScreenCards;
    private GameCardController gameCardController;

    public PlayerUI (GameCardController controller) {
        this.gameCardController = controller;
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        cardViewTimer = new Table();
        stage = new Stage(viewport);
        playerHUD = new PlayerHUD(3, 9, false); // connection to models between player health and lives not implemented
        gameScreenCards = new GameScreenCards(gameCardController);

        stage.addActor(playerHUD.create());
        stage.addActor(playerHUD.powerDown());
        stage.addActor(playerHUD.damageTokens());
        stage.addActor(playerHUD.lifeTokens());
        stage.addActor(cardViewTimer());

        for (int slotNumber = 0; slotNumber < gameCardController.numberOfCardSlots(); slotNumber++)
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
        readyButton = new Button().createTextButton("READY");

        cardViewTimer.row().padTop(20);
        cardViewTimer.add(readyButton);

        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameCardController.setCardSlotsFromUserInput(gameScreenCards.getCardChoices());
            }
        });

        return cardViewTimer;
    }
}
