package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.RoboRally.app.views.cards.CardUI;

public class PlayerUI {

    public Stage stage;
    private CardUI cardUI;
    //private CardButtonsForMovementDemo cards;
    private PlayerHUD player;

    public PlayerUI (SpriteBatch spriteBatch) {
        stage = new Stage();

        cardUI = new CardUI();
        //cards = new CardButtonsForMovementDemo();
        player = new PlayerHUD();

        stage.addActor(cardUI.show());
        //stage.addActor(cards.create(stage));
        stage.addActor(player.create());
    }

}
