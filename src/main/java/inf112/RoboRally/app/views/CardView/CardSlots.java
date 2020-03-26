package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class CardSlots {

    private ICardDragAndDrop[] slotCardViews;
    private Table[] slotTables;

    private final int BOTTOM_PADDING = 8;
    private final int[] LEFT_PADDING = {1977, 2219, 2461, 2703, 2945};

    protected CardSlots(int numberOfCardSlots) {
        slotTables = new Table[numberOfCardSlots];
        slotCardViews = new CardDragSmall[numberOfCardSlots];
        for (int i = 0; i < slotTables.length; i++) {
            slotTables[i] = new Table();
            formatSlotTable(i);
        }
    }

    private void formatSlotTable(int slotNumber) {
        CardDragSmall card = new CardDragSmall(null);
        slotCardViews[slotNumber] = card;
        slotTables[slotNumber].bottom().padBottom(BOTTOM_PADDING);
        slotTables[slotNumber].setTouchable(Touchable.enabled);
        slotTables[slotNumber].add(card.getCardGroup()).padLeft(LEFT_PADDING[slotNumber]);
    }

    protected CardDragSmall getSlotCard(int slotNumber) {
        return (CardDragSmall) slotCardViews[slotNumber];
    }

    protected Table getCardSlotTable(int slotNumber) {
        return slotTables[slotNumber];
    }

    protected boolean slotIsOpen(int slotNumber) {
        return slotCardViews[slotNumber].getModelCard() == null;
    }

    protected void dropCardInSlot(int slotNumber, CardDragBig droppedCard) {
        slotTables[slotNumber].getCells().get(0).clearActor().setActor(slotCardViews[slotNumber].createCardGroup(droppedCard.getModelCard()));

    }
}
