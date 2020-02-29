package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayerUI {

    public Stage stage;
    private CardButtonsForMovementDemo cards;
    private PlayerHUD player;

    public PlayerUI (SpriteBatch spriteBatch) {
        stage = new Stage();

        cards = new CardButtonsForMovementDemo();
        player = new PlayerHUD();

        stage.addActor(cards.create(stage));
        stage.addActor(player.create());
    }

}
