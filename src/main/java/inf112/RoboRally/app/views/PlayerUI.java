package inf112.RoboRally.app.views;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.GameLauncher;
import inf112.RoboRally.app.views.PlayerHUDClasses.DamageToken;
import inf112.RoboRally.app.views.PlayerHUDClasses.LifeToken;
import inf112.RoboRally.app.views.PlayerHUDClasses.PowerDown;
import inf112.RoboRally.app.views.Cards.CardSlotUI;
import inf112.RoboRally.app.views.Cards.CardUI;
import inf112.RoboRally.app.views.Cards.SmallCard;

public class PlayerUI extends InputAdapter {

    private Stage stage;
    private Viewport viewport;
    private CardUI cardUI;
    private PlayerHUD player;
    private CardSlotUI cardSlot;
    private Group smallCard, smallCard2;
    private Table powerdown, damagetoken, lifetoken;

    public PlayerUI (SpriteBatch spriteBatch) {
        viewport = new FitViewport(GameLauncher.GAME_WIDTH, GameLauncher.GAME_HEIGHT);
        stage = new Stage(viewport);
        cardUI = new CardUI();
        player = new PlayerHUD();
        cardSlot = new CardSlotUI();

        powerdown = new PowerDown().init();
        damagetoken = new DamageToken().init();
        lifetoken = new LifeToken().init();

        stage.addActor(player.create());
        stage.addActor(powerdown);
        stage.addActor(damagetoken);
        stage.addActor(lifetoken);
        stage.addActor(cardSlot.cardSlot);
//        stage.addActor(cardUI.show());

        Texture emptyCardTexture = new Texture("Cards/SMALL/MoveBackSmallCard.png");
        emptyCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image test = new Image(emptyCardTexture);

//        DragAndDrop dnd = new DragAndDrop();
//        dnd.addSource(new DragAndDrop.Source(cardUI.cards) {
//            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
//            @Override
//            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
//                payload.setObject(cardUI.card.cardGroup);
//                payload.setDragActor(cardUI.card.cardGroup);
//                return payload;
//            }
//        });
//
//        dnd.addTarget(new DragAndDrop.Target(cardSlot.cardSlot) {
//            @Override
//            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                return true;
//            }
//
//            @Override
//            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                System.out.println("Added");
//                smallCard = new SmallCard().init(cardUI.card.getIndex(), cardUI.card.getPriority());
//                smallCard2 = new SmallCard().init(cardUI.card2.getIndex(), cardUI.card2.getPriority());
//                cardSlot.changeImage(cardSlot.cardImage, smallCard);
//                cardSlot.changeImage(cardSlot.cardImage2, smallCard2);
//            }
//        });

    }

    public Stage getStage () {
        return stage;
    }

    public void dispose() {
        stage.dispose();
    }

}
