package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.models.cards.ICard;

public class CardView extends InputAdapter {


    // Player card controller - communicates player information
    private PlayerCardController playerCardController;

    //Card slots for putting down card choices

    private CardSlots cardSlotsTest; // maybe new refactor

    private ICardDragAndDrop[] cardSlots;
    private Table[] slotTables;
    private int[] leftPadding = {1977, 2219, 2461, 2703, 2945};
    private final int FIRST_SLOT = 0;
    private final int SECOND_SLOT = 1;
    private final int THIRD_SLOT = 2;
    private final int FOURTH_SLOT = 3;
    private final int FIFTH_SLOT = 4;


    //Received cards for click and drag to card slots
    private ReceivedCards receivedCardsClassTest;  //// MAYBE NEW REFACTOR
    private ICardDragAndDrop[] receivedCards;
    private Table receivedCardsTable;


    //DRAG AND DROP
    private int dragAndDropMouseValue;
    private DragAndDrop dragAndDrop;


    public CardView(PlayerCardController controller) {
        this.playerCardController = controller;

        // maybe new refactor
        receivedCardsClassTest = new ReceivedCards(playerCardController.getReceivedPlayerCards());
        cardSlotsTest = new CardSlots(playerCardController.numberOfCardSlots());
        setUpCardSlotTableListener();

//        receivedCards = new CardDragBig[playerCardController.numberOfReceivedCards()];
//        cardSlots = new CardDragSmall[playerCardController.numberOfCardSlots()];
//        slotTables = new Table[playerCardController.numberOfCardSlots()];

//        for (int i = 0; i < slotTables.length; i++) {
//            slotTables[i] = new Table();
//        }
//        receivedCardsTable = new Table();


        setUpDragAndDrop();
        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++) {
            addDragAndDropTarget(slotNumber);
        }
//        addDragAndDropTarget(FIRST_SLOT);
//        addDragAndDropTarget(SECOND_SLOT);
//        addDragAndDropTarget(THIRD_SLOT);
//        addDragAndDropTarget(FOURTH_SLOT);
//        addDragAndDropTarget(FIFTH_SLOT);
    }


    private void addDragAndDropTarget(int slotNumber) {
        Table receivedCardsTable = receivedCardsClassTest.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCardViews = receivedCardsClassTest.getReceivedModelCardViews();
        Table cardSlotTable = cardSlotsTest.getCardSlotTable(slotNumber);

        dragAndDrop.addTarget(new DragAndDrop.Target(cardSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return cardSlotsTest.slotIsOpen(slotNumber);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                cardSlotsTest.dropCardInSlot(slotNumber, receivedCardsClassTest.getReceivedCard(dragAndDropMouseValue));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCardViews[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });

    }

    private void setUpDragAndDrop() {
        Table receivedCardsTable = receivedCardsClassTest.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCardViews = receivedCardsClassTest.getReceivedModelCardViews();

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
                    receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCardViews[dragAndDropMouseValue].createCardGroup(receivedCardsClassTest.getReceivedCard(dragAndDropMouseValue).getModelCard()));
                    receivedCardsClassTest.getReceivedCard(dragAndDropMouseValue).getCardGroup().setZIndex(dragAndDropMouseValue);
//                    getReceivedCard(dragAndDropMouseValue).cardGroup.setZIndex(dragAndDropMouseValue);
                }
            }

        });


    }

    public Table getCardSlotTable(int slotNumber) {
        return cardSlotsTest.getCardSlotTable(slotNumber);
    }



    public Table setUpFirstCardSlot() {
        CardDragSmall card = formatSlotTable(FIRST_SLOT);
        Table table = slotTables[FIRST_SLOT];
        addCardSlotTableListener(table, card);
        return table;
    }

    public Table setUpSecondCardSlot() {
        CardDragSmall card = formatSlotTable(SECOND_SLOT);
        Table table = slotTables[SECOND_SLOT];
        addCardSlotTableListener(table, card);
        return table;
    }


    public Table setUpThirdCardSlot() {
        CardDragSmall card = formatSlotTable(THIRD_SLOT);
        Table table = slotTables[THIRD_SLOT];
        addCardSlotTableListener(table, card);
        return table;
    }


    public Table setUpFourthCardSlot() {
        CardDragSmall card = formatSlotTable(FOURTH_SLOT);
        Table table = slotTables[FOURTH_SLOT];
        addCardSlotTableListener(table, card);
        return table;
    }


    public Table setUpFifthCardSlot() {
        CardDragSmall card = formatSlotTable(FIFTH_SLOT);
        Table table = slotTables[FIFTH_SLOT];
        addCardSlotTableListener(table, card);
        return table;
    }


    private CardDragSmall formatSlotTable(int slotNumber) {
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[slotNumber] = card;
        slotTables[slotNumber].bottom().padBottom(8);
        slotTables[slotNumber].setTouchable(Touchable.enabled);
        slotTables[slotNumber].add(card.getCardGroup()).padLeft(leftPadding[slotNumber]);
        return card;
    }

    private void setUpCardSlotTableListener() {
        for (int slotNumber = 0; slotNumber < playerCardController.numberOfCardSlots(); slotNumber++) {
            Table slotTable = cardSlotsTest.getCardSlotTable(slotNumber);
            ICardDragAndDrop card = cardSlotsTest.getSlotCard(slotNumber);
            slotTable.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                        undoCardSlotChoice(slotTable, card);
                    }
                });
            }
        }


    private void addCardSlotTableListener(Table slotTable, ICardDragAndDrop card) {
        slotTable.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                undoCardSlotChoice(slotTable, card);
            }
        });
    }


    private void undoCardSlotChoice(Table slotTable, ICardDragAndDrop card) {
        ICard modelCard = card.getModelCard();
        Table receivedCardsTable = receivedCardsClassTest.getReceivedCardsTable();
        ICardDragAndDrop[] receivedCards = receivedCardsClassTest.getReceivedModelCardViews();
        if (modelCard != null) {
            for (int i = 0; i < playerCardController.numberOfReceivedCards(); i++) {
                System.out.println("looping");
                if (receivedCardsClassTest.getReceivedCard(i).getModelCard() == null) {
                    receivedCardsTable.getCells().get(i).clearActor().setActor(receivedCards[i].createCardGroup(card.getModelCard()));
                    receivedCardsTable.getCells().get(i).getActor().setZIndex(i);
                    break;
                }

            }

            slotTable.getCells().get(0).setActor(card.createCardGroup(null));
        }

    }



    private void dropCardInSlot(Table table, int slotNumber, CardDragBig droppedCard) {
        table.getCells().get(0).clearActor().setActor(cardSlots[slotNumber].createCardGroup(droppedCard.getModelCard()));
    }



    private boolean slotIsOpen(int slotNumber) {
        return cardSlots[slotNumber].getModelCard() == null;
    }




    //Setting up the players' received cards
    public Table receivedCardsTable() {
        receivedCardsTable.padLeft(4420).padBottom(1200);
        receivedCardsTable.setTouchable(Touchable.enabled);

        ICard[] receivedCards = playerCardController.getReceivedPlayerCards();
        for (int i = 0; i < receivedCards.length; i++) {

            if (receivedCards[i] == null)
                break;

            CardDragBig dragCard = new CardDragBig(receivedCards[i]);
            this.receivedCards[i] = dragCard;

            if          (i == 0) receivedCardsTable.add(dragCard.getCardGroup());
            else if (i % 2 == 1) receivedCardsTable.add(dragCard.getCardGroup()).padLeft(205);
            else {
                receivedCardsTable.row().padTop(275);
                receivedCardsTable.add(dragCard.getCardGroup());
            }
        }

        return receivedCardsTable;
    }


    public Table getReceivedCardsTable() {
        return receivedCardsClassTest.receivedCardsTable();
    }



    private CardDragBig getReceivedCard(int cardIndex) {
        return (CardDragBig) receivedCards[cardIndex];
    }





}
