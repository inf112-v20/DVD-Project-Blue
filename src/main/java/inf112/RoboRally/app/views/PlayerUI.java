package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.views.cards.CardUI;

public class PlayerUI {

    public Stage stage;
    private CardUI cardUI;
    private PlayerHUD player;
    private Table playerC;

    public PlayerUI (SpriteBatch spriteBatch) {
        stage = new Stage();

        playerC = new Table();
        playerC.bottom();
        playerC.setFillParent(true);

        cardUI = new CardUI();
        player = new PlayerHUD();
        //stage.addActor(player.create());
        playerC.bottom();



        Texture txt = new Texture("Images/testImg.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image img = new Image(txt);
        playerC.add(img).center();

        stage.addActor(playerC);
        stage.addActor(cardUI.show());

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

        dnd.addTarget(new DragAndDrop.Target(playerC) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                System.out.println("Added");
                payload.getDragActor().setScale(1/1.5f);
                playerC.add(payload.getDragActor()).bottom();
            }
        });


    }

}
