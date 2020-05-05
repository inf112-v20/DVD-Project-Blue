package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.SortCardByPriority;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SortCardsByPriorityTest {

    @Test
    public void sortByPriority() {
        CardFactory cardFactory = new CardFactory();
        ArrayList<ICard> cards = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            cards.add(cardFactory.randomCard());
        Collections.sort(cards, new SortCardByPriority());
        for (int i = 1; i < cards.size(); i++) {
            ICard cardInFront = cards.get(i-1);
            ICard cardBehind = cards.get(i);
            assertEquals(true, cardInFront.priority() >= cardBehind.priority());
        }
    }

}
