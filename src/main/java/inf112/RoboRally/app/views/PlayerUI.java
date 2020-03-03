package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameScreen;
import inf112.RoboRally.app.views.cards.CardSlotUI;
import inf112.RoboRally.app.views.cards.CardUI;
import inf112.RoboRally.app.views.cards.SmallCard;

public class PlayerUI {

    private Stage stage;
    private Viewport viewport;
    private CardUI cardUI;
    private PlayerHUD player;
    private CardSlotUI cardSlot;
    private Group smallCard, smallCard2;

    public PlayerUI (SpriteBatch spriteBatch) {
        viewport = new FitViewport(GameScreen.GAME_WIDTH, GameScreen.GAME_HEIGHT);
        stage = new Stage(viewport);
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
                payload.setObject(cardUI.card.cardGroup);
                payload.setDragActor(cardUI.card.cardGroup);
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
                smallCard = new SmallCard().init(cardUI.card.getIndex(), cardUI.card.getPriority());
                smallCard2 = new SmallCard().init(cardUI.card2.getIndex(), cardUI.card2.getPriority());
                cardSlot.changeImage(cardSlot.cardImage, smallCard);
                cardSlot.changeImage(cardSlot.cardImage2, smallCard2);
            }
        });

    }

    public Stage getStage () {
        return stage;
    }

    public void dispose() {
        stage.dispose();
    }

}
