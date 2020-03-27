package inf112.RoboRally.app.views.card;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.models.cards.ICard;

/*
Table that holds all the cards to choose from on the game screen
 */
public class ReceivedCards {

    private final int PAD_TABLE_LEFT = 4420;
    private final int PAD_TABLE_BOTTOM = 1200;
    private final int PAD_CARD_LEFT = 205;
    private final int PAD_CARD_TOP = 275;

    private ICard[] receivedModelCards;                  // the model cards
    private ICardDragAndDrop[] receivedModelCardViews;   // the card images
    private Table receivedCardsTable;                    // the table where the cards are placed

    protected ReceivedCards(ICard[] receivedModelCards) {
        this.receivedModelCards = receivedModelCards;
        receivedModelCardViews = new ICardDragAndDrop[receivedModelCards.length];
        receivedCardsTable = new Table();
    }

    protected Table receivedCardsTable() {
        receivedCardsTable.padLeft(PAD_TABLE_LEFT).padBottom(PAD_TABLE_BOTTOM);
        receivedCardsTable.setTouchable(Touchable.enabled);

        for (int i = 0; i < receivedModelCards.length; i++) {

            if (receivedModelCards[i] == null)
                break;

            DragCard dragCard = new DragCard(receivedModelCards[i]);
            this.receivedModelCardViews[i] = dragCard;

            // distributing cards on the table, padding is different for every other card
            if          (i == 0) receivedCardsTable.add(dragCard.getCardGroup());
            else if (i % 2 == 1) receivedCardsTable.add(dragCard.getCardGroup()).padLeft(PAD_CARD_LEFT);
            else {
                receivedCardsTable.row().padTop(PAD_CARD_TOP);
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

    protected DragCard getReceivedCard(int cardIndex) {
        return (DragCard) receivedModelCardViews[cardIndex];
    }



}
