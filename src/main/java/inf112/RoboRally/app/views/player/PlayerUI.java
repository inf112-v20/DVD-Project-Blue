package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.card.GameScreenCards;
import inf112.RoboRally.app.views.menus.Button;
import inf112.RoboRally.app.views.opponents.OpponentHUDTable;

public class PlayerUI extends InputAdapter {

    private Player player; // the player who's thus UI belongs to

    private Table readyButtonTable;
    private TextButton readyButton;

    private Table generateCardsTable;
    private TextButton generateCardsButton;

    private Table powerDownTable;
    private ImageButton powerDownButton;

    private OpponentHUDTable opponentHUDTable;

    private Stage stage;
    private Viewport viewport;
    private PlayerHUD playerHUD;
    private GameScreenCards gameScreenCards;

    public PlayerUI (Player player, boolean cardsFacingUp) {
        this.player = player;
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        stage = new Stage(viewport);

        readyButtonTable = new Table();
        generateCardsTable = new Table();

        powerDownTable = new Table();
        powerDownButton = new PowerDownButton().createImageButton();

        playerHUD = new PlayerHUD(player);
        opponentHUDTable = new OpponentHUDTable(player, cardsFacingUp);

        stage.addActor(opponentHUDTable.getOpponentTable());
        stage.addActor(playerHUD.getPlayerHudDashBoardTable());
        stage.addActor(playerHUD.getDamageTokensTable());
        stage.addActor(powerDownTable());
        stage.addActor(playerHUD.getLifeTokensTable());
        stage.addActor(readyButtonTable());
        stage.addActor(generateCardsTable());

        gameScreenCards = new GameScreenCards(player);
        for (int slotNumber = 0; slotNumber < player.numberOfCardSlots(); slotNumber++)
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

    public Table powerDownTable() {
        powerDownTable.pad(0, 1170, 176, 0);
        powerDownTable.add(powerDownButton);

        //testet, funker nå :D
        powerDownButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (powerDownButton.isChecked()) {
                    System.out.println("YOU ACTIVATED THE POWERDOWN FUNCTION");
                } else {
                    System.out.println("POWER DOWN IS FINISHED, YOU ARE GOOD TO GO");
                }
            }
        });

        return powerDownTable;
    }

    public Table readyButtonTable() {

        readyButtonTable.pad(0, 3765, 430, 0);
        readyButton = new Button().createTextButton("READY");

        readyButtonTable.row().padTop(20);
        readyButtonTable.add(readyButton);

        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("--------------------------------------------------------------------");
//                System.out.println("FROM PlayerUI: ready button pressed! Player is ready for some action!");
                player.setCardSlotsFromUserInput(gameScreenCards.getCardChoices());
                player.getGame().executeRound();
                gameScreenCards.clearReceivedCards();
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
//                System.out.println("--------------------------------------------------------------------");
//                System.out.println("FROM PlayerUI: generated new cards button pressed. Passing this information along.");
                gameScreenCards.clearAllCards();
                player.getGame().newRound();
                gameScreenCards = new GameScreenCards(player);
                for (int slotNumber = 0; slotNumber < player.numberOfCardSlots(); slotNumber++)
                    stage.addActor(gameScreenCards.getCardSlotTable(slotNumber));

                stage.addActor(gameScreenCards.getReceivedCardsTable());
            }
        });

        return generateCardsTable;
    }

    public void updateOpponentCardSlotsCardsFacingUp() {
        opponentHUDTable = new OpponentHUDTable(player, true);
        stage.addActor(opponentHUDTable.getOpponentTable());
    }


    public void updateForNewRound() {
        opponentHUDTable = new OpponentHUDTable(player, false);
        stage.addActor(opponentHUDTable.getOpponentTable());
    }

    public void setupCardsForRoundExecution() {
        player.setCardSlotsFromUserInput(gameScreenCards.getCardChoices());
        gameScreenCards.clearReceivedCards();
    }

    public void clearAllCardsOnScreen() {
        gameScreenCards.clearAllCards();
    }
}
