package inf112.RoboRally.app.models.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByPriority implements Comparator<ICard> {

    // Sorting by priority in descending order
    public int compare(ICard card1, ICard card2) {
        return card1.priority() - card2.priority();
    }


    // quick manual test
    public static void main(String[] args) {
        CardFactory cardFactory = new CardFactory();
        ArrayList<ICard> cards = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            cards.add(cardFactory.randomCard());
        Collections.sort(cards, Collections.reverseOrder(new SortByPriority()));
        for (ICard card: cards)
            System.out.println(card.priority());
    }


}
