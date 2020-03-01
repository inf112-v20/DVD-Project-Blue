package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.views.PlayerHUD;
import org.lwjgl.Sys;

import java.util.Random;

public class CardUI {

    private Random random;

    public Group card, card2, card3, card4, card5, card6,
            card7, card8, card9;

    public Table cards;

    public Table show () {
        cards = new Table();
        cards.center().padRight(190);
        cards.setFillParent(true);

        random = new Random();

        card = new Card().init(0, 999);
        card2 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card3 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card4 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card5 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card6 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card7 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card8 = new Card().init(random.nextInt(6), random.nextInt(1999));
        card9 = new Card().init(random.nextInt(6), random.nextInt(1999));

        cards.add(card);
        cards.add(card2).padLeft(165);
        cards.add(card3).padLeft(165);
        cards.add(card4).padLeft(165);
        cards.add(card5).padLeft(165);
        cards.add(card6).padLeft(165);
        cards.add(card7).padLeft(165);
        cards.add(card8).padLeft(165);
        cards.add(card9).padLeft(165);
//
//        DragAndDrop dnd = new DragAndDrop();
//        dnd.addSource(new DragAndDrop.Source(cards) {
//            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
//            @Override
//            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
//                payload.setObject(card);
//                payload.setDragActor(card);
//                return payload;
//            }
//        });
//
//        dnd.addTarget(new DragAndDrop.Target(playerCards) {
//            @Override
//            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                //System.out.println("aded");
//                return true;
//            }
//
//            @Override
//            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
//                System.out.println("aded");
//                playerCards.addActor(payload.getDragActor());
//            }
//        });

        return cards;
    }

}
