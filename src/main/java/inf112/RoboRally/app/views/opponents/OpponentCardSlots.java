package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.scenes.scene2d.Group;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;

public class OpponentCardSlots {

    private final float Y_CARD_POS = 11;
    private final float[] X_CARD_POS = {18, 86, 154, 222, 290};

    private OpponentHUDCard[] slotCardViews; // not needed?
    private Group[] cardSlotGroup;

    public OpponentCardSlots(Player player) {
        int numberOfCardSlots = player.numberOfCardSlots();
        cardSlotGroup = new Group[numberOfCardSlots];
        slotCardViews = new OpponentHUDCard[numberOfCardSlots];
        for (int slotNumber = 0; slotNumber < numberOfCardSlots; slotNumber++) {
            ICard card = player.getCardFromSlotNumber(slotNumber);
            OpponentHUDCard oppCard = new OpponentHUDCard(card);
            formatGroupSlot(oppCard, slotNumber);
        }
    }

    private void formatGroupSlot(OpponentHUDCard oppCard, int slotNumber) {
        cardSlotGroup[slotNumber] = oppCard.getCardGroup();
        cardSlotGroup[slotNumber].setPosition( X_CARD_POS[slotNumber] , Y_CARD_POS );
    }

    public Group[] getCardSlotGroup() {
        return cardSlotGroup;
    }
}
