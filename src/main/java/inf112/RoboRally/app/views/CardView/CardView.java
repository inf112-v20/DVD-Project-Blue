package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.controllers.CardControllers.PlayerCardController;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.views.Screens.Button;

public class CardView extends InputAdapter {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    private Table cardViewTimer;
    private final int timer = 30;
    private TextButton readyButton;

    // Player card controller - communicates player information
    private PlayerCardController playerCardController;


    //Card slots for putting down card choices
    private ICardDragAndDrop[] cardSlots;
    private Table firstSlotTable;
    private Table secondSlotTable;
    private Table thirdSlotTable;
    private Table fourthSlotTable;
    private Table fifthSlotTable;


    //Received cards for click and drag to card slots
    private ICardDragAndDrop[] receivedCards;
    private Table receivedCardsTable;

    //DRAG AND DROP
    private int dragAndDropMouseValue;

    public CardView(PlayerCardController controller) {
        this.playerCardController = controller;
        cardViewTimer = new Table();
        receivedCardsTable = new Table();
        receivedCards = new CardDragBig[playerCardController.numberOfReceivedCards()];
        cardSlots = new CardDragSmall[playerCardController.numberOfCardSlots()];

        firstSlotTable = new Table();
        secondSlotTable = new Table();
        thirdSlotTable = new Table();
        fourthSlotTable = new Table();
        fifthSlotTable = new Table();

        DragAndDrop dnd = new DragAndDrop();
        dnd.setDragActorPosition(-41, -44);
        dnd.addSource(new DragAndDrop.Source(receivedCardsTable) {
            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                payload.setObject(event.getTarget().getParent());
                payload.setDragActor(event.getTarget().getParent());
                payload.getDragActor().setScale(1/2.2f);
                dragAndDropMouseValue = payload.getDragActor().getZIndex();
                return payload;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                if (target == null) {
                    receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(getCard(dragAndDropMouseValue).getModelCard()));
                    getCard(dragAndDropMouseValue).cardGroup.setZIndex(dragAndDropMouseValue);
                }
            }
        });
        dnd.addTarget(new DragAndDrop.Target(firstSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return slotIsOpen(0);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                testDropCard(firstSlotTable,0, getCard(dragAndDropMouseValue));
                firstSlotTable.getCells().get(0).getActor().setZIndex(0);
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });
        dnd.addTarget(new DragAndDrop.Target(secondSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return slotIsOpen(1);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                testDropCard(secondSlotTable,1, getCard(dragAndDropMouseValue));
                secondSlotTable.getCells().get(0).getActor().setZIndex(1);
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });
        dnd.addTarget(new DragAndDrop.Target(thirdSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return slotIsOpen(2);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                testDropCard(thirdSlotTable,2, getCard(dragAndDropMouseValue));
                thirdSlotTable.getCells().get(0).getActor().setZIndex(2);
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });
        dnd.addTarget(new DragAndDrop.Target(fourthSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return slotIsOpen(3);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                testDropCard(fourthSlotTable,3, getCard(dragAndDropMouseValue));
                fourthSlotTable.getCells().get(0).getActor().setZIndex(3);
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });
        dnd.addTarget(new DragAndDrop.Target(fifthSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                return slotIsOpen(4);
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float v, float v1, int i) {
                testDropCard(fifthSlotTable,4, getCard(dragAndDropMouseValue));
                fifthSlotTable.getCells().get(0).getActor().setZIndex(4);
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);
            }
        });


    }

    

    public Table firstSlotTable() {
        firstSlotTable.bottom().padBottom(8);
        firstSlotTable.setTouchable(Touchable.enabled);
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[0] = card;
        firstSlotTable.add(card.getCardGroup()).padLeft(1980); // 2461 middle of the table
//        firstSlotTable.getCells().get(0).getActor().setZIndex(0);


        addCardSlotTableListener(firstSlotTable, card);

        return firstSlotTable;
    }

    public Table secondSlotTable() {
        secondSlotTable.bottom().padBottom(8);
        secondSlotTable.setTouchable(Touchable.enabled);
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[1] = card;
        secondSlotTable.add(card.getCardGroup()).padLeft(2220); // 2461 middle of the table
//        secondSlotTable.getCells().get(0).getActor().setZIndex(1);

        addCardSlotTableListener(secondSlotTable, card);

        return secondSlotTable;
    }


    public Table thirdSlotTable() {
        thirdSlotTable.bottom().padBottom(8);
        thirdSlotTable.setTouchable(Touchable.enabled);
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[2] = card;
        thirdSlotTable.add(card.getCardGroup()).padLeft(2460); // 2461 middle of the table
//        thirdSlotTable.getCells().get(0).getActor().setZIndex(3);

        addCardSlotTableListener(thirdSlotTable, card);

        return thirdSlotTable;
    }



    public Table fourthSlotTable() {
        fourthSlotTable.bottom().padBottom(8);
        fourthSlotTable.setTouchable(Touchable.enabled);
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[3] = card;
        fourthSlotTable.add(card.getCardGroup()).padLeft(2701); // 2461 middle of the table
//        fourthSlotTable.getCells().get(0).getActor().setZIndex(4);

        addCardSlotTableListener(fourthSlotTable, card);

        return fourthSlotTable;
    }


    public Table fifthSlotTable() {
        fifthSlotTable.bottom().padBottom(8);
        fifthSlotTable.setTouchable(Touchable.enabled);
        CardDragSmall card = new CardDragSmall(null);
        cardSlots[4] = card;
        fifthSlotTable.add(card.getCardGroup()).padLeft(2941); // 2461 middle of the table
//        fifthSlotTable.getCells().get(0).getActor().setZIndex(4);

        addCardSlotTableListener(fifthSlotTable, card);

        return fifthSlotTable;
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
        if (modelCard != null) {
            for (int i = 0; i < receivedCards.length; i++) {
                if (getCard(i).getModelCard() == null) {
                    receivedCardsTable.getCells().get(i).clearActor().setActor(receivedCards[i].createCardGroup(card.getModelCard()));
                    receivedCardsTable.getCells().get(i).getActor().setZIndex(i);
                    break;
                }

            }

            slotTable.getCells().get(0).setActor(card.createCardGroup(null));
        }

    }



    private void testDropCard(Table table, int slotNumber, CardDragBig droppedCard) {
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



    private CardDragBig getCard(int cardIndex) {
        return (CardDragBig) receivedCards[cardIndex];
    }








    public Table cardViewTimer() {
        cardViewTimer.pad(0, 3830, 250, 0);

        Label timerLabel = new Label(String.format("%02d", timer),skin);
        readyButton = new Button().createTextButton("RUN");

        cardViewTimer.add(timerLabel);
        cardViewTimer.row().padTop(20);
        cardViewTimer.add(readyButton);

        readyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                receivedCardsTable().clear();
            }
        });

        return cardViewTimer;
    }



    public TextButton getReadyButton() {
        return readyButton;
    }

}
