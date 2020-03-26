package inf112.RoboRally.app.views.card;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.models.cards.ICard;


/*
Class that connects the card slot and received card in the game screen to each other, and adds drag and drop functionality.
 */
public class GameScreenCards extends InputAdapter {

    private PlayerCardController playerCardController;   // Player card controller - communicates player information
    private CardSlots cardSlots;                         // Class that holds all card slot tables for dropping cards
    private ReceivedCards receivedCards;                 // Class that holds table with the received cards

    private int dragAndDropMouseValue;
    private DragAndDrop dragAndDrop;


    public GameScreenCards(PlayerCardController controller) {
        this.playerCardController = controller;
        receivedCards = new ReceivedCards(playerCardController.getReceivedPlayerCards());
        cardSlots = new CardSlots(playerCardController.numberOfCardSlots());
        setUpCardSlotTableListener();
        setUpDragAndDrop();
        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++)
            addDragAndDropTarget(slotNumber);

    }


    private void addDragAndDropTarget(int slotNumber) {
        Table receivedCardsTable = receivedCards.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCardViews = receivedCards.getReceivedModelCardViews();
        Table cardSlotTable = cardSlots.getCardSlotTable(slotNumber);

        dragAndDrop.addTarget(new DragAndDrop.Target(cardSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return cardSlots.slotIsOpen(slotNumber);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                cardSlots.dropCardInSlot(slotNumber, receivedCards.getReceivedCard(dragAndDropMouseValue));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCardViews[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });

    }

    private void setUpDragAndDrop() {
        Table receivedCardsTable = receivedCards.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCardViews = receivedCards.getReceivedModelCardViews();

        dragAndDrop = new DragAndDrop();
        dragAndDrop.setDragActorPosition(-41, -44);
        dragAndDrop.addSource(new DragAndDrop.Source(receivedCardsTable) {
            final DragAndDrop.Payload PAYLOAD = new DragAndDrop.Payload();
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                PAYLOAD.setObject(event.getTarget().getParent());
                PAYLOAD.setDragActor(event.getTarget().getParent());
                PAYLOAD.getDragActor().setScale(1/2.2f);
                dragAndDropMouseValue = PAYLOAD.getDragActor().getZIndex();
                return PAYLOAD;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                if (target == null) {
                    receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCardViews[dragAndDropMouseValue].createCardGroup(receivedCards.getReceivedCard(dragAndDropMouseValue).getModelCard()));
                    receivedCards.getReceivedCard(dragAndDropMouseValue).getCardGroup().setZIndex(dragAndDropMouseValue);
                }
            }

        });


    }

    // setting up mouse click listeners on all card slots for undoing card choice
    private void setUpCardSlotTableListener() {
        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++) {
            Table slotTable = cardSlots.getCardSlotTable(slotNumber);
            ICardDragAndDrop card = cardSlots.getSlotCard(slotNumber);
            slotTable.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                        undoCardSlotChoice(slotTable, card);
                    }
                });
            }
        }


    private void undoCardSlotChoice(Table slotTable, ICardDragAndDrop card) {
        ICard modelCard = card.getModelCard();
        Table receivedCardsTable = receivedCards.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCards = this.receivedCards.getReceivedModelCardViews();
        if (modelCard != null) {
            for (int i = 0; i < playerCardController.amountOfReceivedCards(); i++) {
                if (this.receivedCards.getReceivedCard(i).getModelCard() == null) {
                    receivedCardsTable.getCells().get(i).clearActor().setActor(receivedCards[i].createCardGroup(card.getModelCard()));
                    receivedCardsTable.getCells().get(i).getActor().setZIndex(i);
                    break;
                }

            }

            slotTable.getCells().get(0).setActor(card.createCardGroup(null));
        }

    }


    public Table getReceivedCardsTable() {
        return receivedCards.receivedCardsTable();
    }

    public Table getCardSlotTable(int slotNumber) {
        return cardSlots.getCardSlotTable(slotNumber);
    }

    public ICardDragAndDrop[] cardChoiceReady() {
        System.out.println("Got here! what");
        ICardDragAndDrop[] cardChoices = cardSlots.getSlotCardViews();
        for (ICardDragAndDrop viewCard: cardChoices) {
            if (viewCard.getModelCard() == null)
                return null;

        }
        return cardChoices;
    }
}
