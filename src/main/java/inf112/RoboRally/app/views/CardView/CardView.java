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

    // Card controller - communicates game information
    private PlayerCardController playerCardController;

    //CARD SLOTS
    private ICardDragAndDrop[] cardSlots;
    private Table[] cardSlotdemo;
    private Table cardSlotTable;

    //CARD DECK
    private ICardDragAndDrop[] receivedCards;
    private Table receivedCardsTable;

    //DRAG AND DROP
    private int dragAndDropMouseValue;

    public CardView(PlayerCardController controller) {
        this.playerCardController = controller;
        cardViewTimer = new Table();
        receivedCardsTable = new Table();
        cardSlotTable = new Table();
        receivedCards = new CardDragBig[playerCardController.getPlayer().amountOfReceivedCards()];
        cardSlots = new CardDragSmall[playerCardController.numberOfCardSlots()];

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
                    receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(getCard(dragAndDropMouseValue).getCard()));
                    getCard(dragAndDropMouseValue).cardGroup.setZIndex(dragAndDropMouseValue);
                }
            }
        });
        dnd.addTarget(new DragAndDrop.Target(cardSlotTable) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return openSlots();
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                if (openSlots()) {
                    if (cardSlots[0].getCard() == null) {
                        dropCard(0, getCard(dragAndDropMouseValue));
                        cardSlotTable.getCells().get(0).getActor().setZIndex(0);
                    }
                    else if (cardSlots[1].getCard() == null) {
                        dropCard(1, getCard(dragAndDropMouseValue));
                        cardSlotTable.getCells().get(1).getActor().setZIndex(1);
                    }
                    else if (cardSlots[2].getCard() == null) {
                        dropCard(2, getCard(dragAndDropMouseValue));
                        cardSlotTable.getCells().get(2).getActor().setZIndex(2);
                    }
                    else if (cardSlots[3].getCard() == null) {
                        dropCard(3, getCard(dragAndDropMouseValue));
                        cardSlotTable.getCells().get(3).getActor().setZIndex(3);
                    }
                    else if (cardSlots[4].getCard() == null) {
                        dropCard(4, getCard(dragAndDropMouseValue));
                        cardSlotTable.getCells().get(4).getActor().setZIndex(4);
                    }
                }
                receivedCardsTable.getCells().get(dragAndDropMouseValue).setActor(receivedCards[dragAndDropMouseValue].createCardGroup(null));
                receivedCardsTable.getCells().get(dragAndDropMouseValue).getActor().setZIndex(dragAndDropMouseValue);


            }

        });

    }





    // Chosen cards
    public Table cardsSlotTable() {
        cardSlotTable.bottom().padBottom(8);
        cardSlotTable.setTouchable(Touchable.enabled);
        for (int i = 0; i < 5; i++) {
            CardDragSmall dragCard = new CardDragSmall(null);
            cardSlots[i] = dragCard;
            if (i == 0) cardSlotTable.add(dragCard.getCardGroup()).padLeft(2461);
            else        cardSlotTable.add(dragCard.getCardGroup()).padLeft(121);
            cardSlotTable.getCells().get(i).getActor().setZIndex(i);
        }


        cardSlotTable.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int mouseClickPosition = event.getTarget().getParent().getZIndex();
                ICardDragAndDrop clickedCard = cardSlots[mouseClickPosition];
                if (clickedCard != null) {

                    // TODO - extract method
                    for (int availableCardSpot = 0; availableCardSpot < receivedCards.length; availableCardSpot++) {
                        if (getCard(availableCardSpot).getCard() == null) {
                            receivedCardsTable.getCells().get(availableCardSpot).clearActor().setActor(receivedCards[availableCardSpot].createCardGroup(clickedCard.getCard()));
                            receivedCardsTable.getCells().get(availableCardSpot).getActor().setZIndex(availableCardSpot);
                            break;
                        }
                    }

                    cardSlotTable.getCells().get(mouseClickPosition).setActor(clickedCard.createCardGroup(null));
                    receivedCardsTable.getCells().get(mouseClickPosition).getActor().setZIndex(mouseClickPosition);
                }

            }
        });


        return cardSlotTable;
    }



    public void changeSmallCard(int cardIndex) {
        cardSlotTable.getCells().get(cardIndex).clearActor().setActor(receivedCards[cardIndex].getCardGroup());
    }

    private void dropCard(int slotPosition, CardDragBig droppedCard) {
        cardSlotTable.getCells().get(slotPosition).clearActor().setActor(cardSlots[slotPosition].createCardGroup(droppedCard.getCard()));
    }


    private boolean openSlots() {
        for (ICardDragAndDrop card: cardSlots)
            if (card.getCard() == null) return true;
        return false;
    }


//    public boolean allSmallCardsChanged() {
//        boolean allEqual = true;
//        for (boolean bool : chosenCardChanged) {
//            if (!bool) {
//                allEqual = false;
//                break;
//            }
//        }
//        return !allEqual;
//    }





    //Setting up cards to choose from
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
