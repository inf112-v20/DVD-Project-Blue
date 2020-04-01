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
import inf112.RoboRally.app.views.opponents.OpponentHUD;

public class PlayerUI extends InputAdapter {

    private Table readyButtonTable;
    private TextButton readyButton;

    private Table generateCardsTable;
    private TextButton generateCardsButton;

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;

    // opponent hud code
    private OpponentHUD opponentHUD;
    private OpponentHUD opponentHUD2;
    private OpponentHUD opponentHUD3;
    private OpponentHUD opponentHUD4;
    private OpponentHUD opponentHUD5;
    private OpponentHUD opponentHUD6;
    private OpponentHUD opponentHUD7;
    // opponent hud code

    private GameScreenCards gameScreenCards;
    private GameCardController gameCardController;

    public PlayerUI (GameCardController controller) {
        this.gameCardController = controller;
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        stage = new Stage(viewport);

        readyButtonTable = new Table();
        generateCardsTable = new Table();

        playerHUD = new PlayerHUD(gameCardController); // connection to models between player health and lives not implemented

        // opponent hud code
        Table opponents = new Table();
        opponents.left();
        opponents.setFillParent(true);
        opponentHUD = new OpponentHUD(2, 2, 10, true);
        opponentHUD2 = new OpponentHUD(3, 3, 1, true);
        opponentHUD3 = new OpponentHUD(4, 1, 9, false);
        opponentHUD4 = new OpponentHUD(5, 2, 5, true);
        opponentHUD5 = new OpponentHUD(6, 3, 1, false);
        opponentHUD6 = new OpponentHUD(7, 1, 9, false);
        opponentHUD7 = new OpponentHUD(8, 2, 5, true);

        opponents.add(opponentHUD.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD2.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD3.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD4.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD5.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD6.opponentDashboard());
        opponents.row().padTop(12);
        opponents.add(opponentHUD7.opponentDashboard());
        // opponent hud code

        stage.addActor(playerHUD.getPlayerHudDashBoardTable());
        stage.addActor(playerHUD.getDamageTokensTable());
        stage.addActor(playerHUD.getPowerDownTable());
        stage.addActor(playerHUD.getLifeTokensTable());

        // opponent hud code
        stage.addActor(opponents);
        // opponent hud code

        stage.addActor(readyButtonTable());
        stage.addActor(generateCardsTable());

        gameScreenCards = new GameScreenCards(gameCardController);
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


    public Table readyButtonTable() {

        readyButtonTable.pad(0, 3765, 430, 0);
        readyButton = new Button().createTextButton("READY");

        readyButtonTable.row().padTop(20);
        readyButtonTable.add(readyButton);

        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("FROM PlayerUI: ready button pressed! Player is ready for some action!");
                gameCardController.setCardSlotsFromUserInput(gameScreenCards.getCardChoices());
                gameScreenCards.clearCards();
            }
        });

        return readyButtonTable;
    }

    public Table generateCardsTable() {

        generateCardsTable.pad(0, 3765, 180, 0);
        generateCardsButton = new Button().createTextButton("CARDS");

        generateCardsTable.row().padTop(20);
        generateCardsTable.add(generateCardsButton);

        generateCardsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("FROM PlayerUI: generated new cards button pressed. Passing this information along.");
                gameScreenCards.clearCards();
                gameCardController.newRound();
                gameScreenCards = new GameScreenCards(gameCardController);
                for (int slotNumber = 0; slotNumber < gameCardController.numberOfCardSlots(); slotNumber++)
                    stage.addActor(gameScreenCards.getCardSlotTable(slotNumber));

                stage.addActor(gameScreenCards.getReceivedCardsTable());
            }
        });

        return generateCardsTable;
    }
}
