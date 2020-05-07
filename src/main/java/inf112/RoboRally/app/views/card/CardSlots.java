package inf112.RoboRally.app.views.card;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.models.cards.ICard;

/*
Table that represents slots for putting down your card choices.
 */
public class CardSlots {

    private ICardDragAndDrop[] slotCardViews;
    private Table[] slotTables;

    private final int BOTTOM_PADDING = 8;
    private final int[] LEFT_PADDING = {1418, 1778, 2138, 2498, 2858};  // paddings for the slots, index 0 is the first card slot etc.

    protected CardSlots(ICard[] cardSlots, int numberOfCardSlots) {
        slotTables = new Table[numberOfCardSlots];
        slotCardViews = new DropCard[numberOfCardSlots];
        for (int slotNumber = 0; slotNumber < slotTables.length; slotNumber++) {
            slotTables[slotNumber] = new Table();
            ICard cardInSlot = cardSlots[slotNumber];
            formatSlotTable(slotNumber, cardInSlot);
        }
    }

    private void formatSlotTable(int slotNumber, ICard modelCard) {
        DropCard card = new DropCard(modelCard);
        slotCardViews[slotNumber] = card;
        slotTables[slotNumber].bottom().padBottom(BOTTOM_PADDING);
        slotTables[slotNumber].setTouchable(Touchable.enabled);
        slotTables[slotNumber].add(card.getCardGroup()).padLeft(LEFT_PADDING[slotNumber]);
    }

    protected DropCard getSlotCard(int slotNumber) {
        return (DropCard) slotCardViews[slotNumber];
    }

    protected Table getCardSlotTable(int slotNumber) {
        return slotTables[slotNumber];
    }

    protected boolean slotIsOpen(int slotNumber) {
        return slotCardViews[slotNumber].getModelCard() == null;
    }

    protected void dropCardInSlot(int slotNumber, DragCard droppedCard) {
        slotTables[slotNumber].getCells().get(0).clearActor().setActor(slotCardViews[slotNumber].createCardGroup(droppedCard.getModelCard()));
    }

    protected ICardDragAndDrop[] getSlotCardViews() {
        return slotCardViews;
    }
}
