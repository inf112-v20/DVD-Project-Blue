package inf112.RoboRally.app.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.views.cards.Card;
import inf112.RoboRally.app.views.cards.CardSlotUI;
import inf112.RoboRally.app.views.cards.CardUI;

public class PlayerUI {

    public Stage stage;
    private CardUI cardUI;
    private PlayerHUD player;
    private Table playerC;
    private CardSlotUI cardSlotUIx;
    private Table cardtable;

    public PlayerUI (SpriteBatch spriteBatch) {
        stage = new Stage();

        playerC = new Table();
        playerC.bottom();
        playerC.setFillParent(true);
        //playerC.setPosition(100, 0);

        cardUI = new CardUI();
        player = new PlayerHUD();
        cardSlotUIx = new CardSlotUI();
        stage.addActor(player.create());



        Texture txt = new Texture("Images/cardslot.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image img3 = new Image(txt);
        playerC.add(img3);
        playerC.setDebug(true);

        //stage.addActor(playerC);

        //stage.addActor(cardSlotUI.init());
        cardtable = new CardSlotUI().init();
        stage.addActor(cardtable);
        stage.addActor(cardUI.show());

        cardtable.add(img3);
        //cardSlotUIx.addimg(img3);

        Texture txt2 = new Texture("Images/cardslot2.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image img4 = new Image(txt2);

        //cardSlotUI.changeImg(cardSlotUI.img, txt2);

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

        dnd.addTarget(new DragAndDrop.Target(cardtable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                System.out.println("Added");
                cardtable.getCell(img3).clearActor().setActor(cardUI.card);
                //payload.getDragActor().setScale(1/1.5f);
//                if (Gdx.input.getX() == cardSlotUIx.img.getX()) {
//
//                    cardSlotUI.changeImg(cardSlotUI.img);
//                }
//                cardSlotUIx.changeImg(cardSlotUIx.img);
            }
        });


    }

}
