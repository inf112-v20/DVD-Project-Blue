package inf112.RoboRally.app.models.cards;

import java.util.Comparator;

public class SortCardByPriority implements Comparator<ICard> {

    // Sorting by priority in descending order
    public int compare(ICard card1, ICard card2) {
        return card2.priority() - card1.priority();
    }

}
