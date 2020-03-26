package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.models.cards.ICard;

public class ReceivedCards {

    private ICard[] receivedModelCards;                  // the model cards
    private ICardDragAndDrop[] receivedModelCardViews;   // the card images
    private Table receivedCardsTable;                    // the table where the cards are placed

    protected ReceivedCards(ICard[] receivedModelCards) {
        this.receivedModelCards = receivedModelCards;
        receivedModelCardViews = new ICardDragAndDrop[receivedModelCards.length];
        receivedCardsTable = new Table();
    }

    protected Table receivedCardsTable() {
        receivedCardsTable.padLeft(4420).padBottom(1200);
        receivedCardsTable.setTouchable(Touchable.enabled);

        for (int i = 0; i < receivedModelCards.length; i++) {

            if (receivedModelCards[i] == null)
                break;

            CardDragBig dragCard = new CardDragBig(receivedModelCards[i]);
            this.receivedModelCardViews[i] = dragCard;

            // distributing cards on the table
            if          (i == 0) receivedCardsTable.add(dragCard.getCardGroup());
            else if (i % 2 == 1) receivedCardsTable.add(dragCard.getCardGroup()).padLeft(205);
            else {
                receivedCardsTable.row().padTop(275);
                receivedCardsTable.add(dragCard.getCardGroup());
            }
        }

        return receivedCardsTable;
    }

    protected Table getReceivedCardsTable() {
        return receivedCardsTable;
    }

    protected ICardDragAndDrop[] getReceivedModelCardViews() {
        return receivedModelCardViews;
    }

    protected CardDragBig getReceivedCard(int cardIndex) {
        return (CardDragBig) receivedModelCardViews[cardIndex];
    }
}
