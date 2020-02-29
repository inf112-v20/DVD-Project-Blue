package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Align;

public class CardUI {

    public Card card, card2, card3, card4, card5, card6,
            card7, card8, card9;

    public Table show () {
        Table cards = new Table();
        cards.center().padRight(190);
        cards.setFillParent(true);

        card = new Card();
        card2 = new Card();
        card3 = new Card();
        card4 = new Card();
        card5 = new Card();
        card6 = new Card();
        card7 = new Card();
        card8 = new Card();
        card9 = new Card();

        cards.add(card.move1(1));
        cards.add(card2.move1(2)).padLeft(200);
        cards.add(card3.move1(3)).padLeft(200);
        cards.add(card4.move1(4)).padLeft(200);
        cards.add(card5.move1(5)).padLeft(200);
        cards.add(card6.move1(6)).padLeft(200);
        cards.add(card7.move1(7)).padLeft(200);
        cards.add(card8.move1(8)).padLeft(200);
        cards.add(card9.move1(9)).padLeft(200);

        DragAndDrop dnd = new DragAndDrop();
        dnd.addSource(new DragAndDrop.Source(cards) {
            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                payload.setObject(card.move1(1));
                payload.setDragActor(card.move1(1));
                return payload;
            }
        });

        return cards;
    }

}
