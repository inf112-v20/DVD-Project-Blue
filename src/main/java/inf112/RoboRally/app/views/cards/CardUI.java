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

    public Card card, card2, card3, card4, card5, card6,
            card7, card8, card9;

    public Card test;

    public Table cards;

    public Table show () {
        cards = new Table();
        cards.center().padRight(190);
        cards.setFillParent(true);

        random = new Random();

        card = new Card();
        card2 = new Card();
        card3 = new Card();
        card4 = new Card();
        card5 = new Card();
        card6 = new Card();
        card7 = new Card();
        card8 = new Card();
        card9 = new Card();

        cards.add(card.init(0, 9999));
        cards.add(card2.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card3.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card4.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card5.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card6.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card7.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card8.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
        cards.add(card9.init(random.nextInt(6), random.nextInt(1999))).padLeft(165);
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
