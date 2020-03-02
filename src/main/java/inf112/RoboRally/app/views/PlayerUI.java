package inf112.RoboRally.app.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.views.cards.CardSlotUI;
import inf112.RoboRally.app.views.cards.CardUI;

import java.security.Key;

public class PlayerUI {

    public Stage stage;
    private CardUI cardUI;
    private PlayerHUD player;
    private CardSlotUI cardSlot;

    public PlayerUI (SpriteBatch spriteBatch) {
        stage = new Stage();
        cardUI = new CardUI();
        player = new PlayerHUD();
        cardSlot = new CardSlotUI();
        stage.addActor(player.create());
        stage.addActor(cardSlot.cardSlot);
        stage.addActor(cardUI.show());

        Texture emptyCardTexture = new Texture("Images/MoveBackSmallCard.png");
        emptyCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image test = new Image(emptyCardTexture);

        DragAndDrop dnd = new DragAndDrop();
        dnd.addSource(new DragAndDrop.Source(cardUI.cards) {
            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                payload.setObject(cardUI.card);
                payload.setDragActor(cardUI.card);
                return payload;
            }
        });

        dnd.addTarget(new DragAndDrop.Target(cardSlot.cardSlot) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                System.out.println("Added");
                cardSlot.changeImage(cardSlot.cardImage, test);
            }
        });

    }

}
