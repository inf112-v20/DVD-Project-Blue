package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import inf112.RoboRally.app.views.Screens.Button;

import java.util.Random;

public class CardView extends InputAdapter {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    private Table cardViewTimer;
    private final int timer = 30;
    private TextButton runButton;

    //CARD SLOT
    private Table cardSlot;
    private ICard[] smallCards;
    private boolean[] smallCardsChanged;
    private int smallCardDeckCount;
    //CARD SLOT

    //CARD DECK
    private ICard[] cards;
    private Table cardDeck;
    private int cardDeckCount;
    //CARD DECK

    //DRAG AND DROP
    private int cardIndexDnD;
    private int cardZIndex;
    private int card2ZIndex;
    private int card3ZIndex;
    private int card4ZIndex;
    private int card5ZIndex;
    //DRAG AND DROP

    public CardView(int cardDeckCount, int smallCardDeckCount) {
        this.cardDeckCount = cardDeckCount;
        this.smallCardDeckCount = smallCardDeckCount;
        cardViewTimer = new Table();
        cardDeck = new Table();
        cardSlot = new Table();
        cards = new Card[cardDeckCount];
        smallCards = new SmallCard[5];
        smallCardsChanged = new boolean[5];

        DragAndDrop dnd = new DragAndDrop();
        dnd.setDragActorPosition(-41, -44);
        dnd.addSource(new DragAndDrop.Source(cardDeck) {
            final DragAndDrop.Payload payload = new DragAndDrop.Payload();
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                payload.setObject(event.getTarget().getParent());
                payload.setDragActor(event.getTarget().getParent());
                payload.getDragActor().setScale(1/2.2f);
                cardIndexDnD = payload.getDragActor().getZIndex();
                return payload;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                if (target == null) {
                    cardDeck.getCells().get(cardIndexDnD).setActor(cards[cardIndexDnD].init(getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority()));
                    getCard(cardIndexDnD).cardGroup.setZIndex(cardIndexDnD);
                }
            }
        });
        dnd.addTarget(new DragAndDrop.Target(cardSlot) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return allSmallCardsChanged();
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                if (allSmallCardsChanged()) {
                    if (!smallCardsChanged[0]) {
                        changeSmallCard(0, getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority());
                        smallCardsChanged[0] = true;
                        cardZIndex = cardIndexDnD;
                        cardSlot.getCells().get(0).getActor().setZIndex(0);
                    } else if (!smallCardsChanged[1]) {
                        changeSmallCard(1, getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority());
                        smallCardsChanged[1] = true;
                        card2ZIndex = cardIndexDnD;
                        cardSlot.getCells().get(1).getActor().setZIndex(1);
                    } else if (!smallCardsChanged[2]) {
                        changeSmallCard(2, getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority());
                        smallCardsChanged[2] = true;
                        card3ZIndex = cardIndexDnD;
                        cardSlot.getCells().get(2).getActor().setZIndex(2);
                    } else if (!smallCardsChanged[3]) {
                        changeSmallCard(3, getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority());
                        smallCardsChanged[3] = true;
                        card4ZIndex = cardIndexDnD;
                        cardSlot.getCells().get(3).getActor().setZIndex(3);
                    } else if (!smallCardsChanged[4]) {
                        changeSmallCard(4, getCard(cardIndexDnD).getIndex(), getCard(cardIndexDnD).getPriority());
                        smallCardsChanged[4] = true;
                        card5ZIndex = cardIndexDnD;
                        cardSlot.getCells().get(4).getActor().setZIndex(4);
                    }
                }
                cardDeck.getCells().get(cardIndexDnD).setActor(cards[cardIndexDnD].init(7, 0));
                cardDeck.getCells().get(cardIndexDnD).getActor().setZIndex(cardIndexDnD);
            }
        });
    }

    public Table cardViewTimer() {
        cardViewTimer.pad(0, 3830, 250, 0);

        Label timerLabel = new Label(String.format("%02d", timer),skin);
        runButton = new Button().createTextButton("RUN");

        cardViewTimer.add(timerLabel);
        cardViewTimer.row().padTop(20);
        cardViewTimer.add(runButton);

        runButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                CardDeck().clear();
            }
        });

        return cardViewTimer;
    }

    public TextButton getRunButton() {
        return runButton;
    }

    //PLAYER CARD HAND
    public Table CardSlot() {
        cardSlot.bottom().padBottom(8);
        cardSlot.setTouchable(Touchable.enabled);
        for (int i = 0; i < 5; i++) {
            smallCards[i] = new SmallCard();
            smallCardsChanged[i] = false;
        }

        cardSlot.add(smallCards[0].init(8, 0)).padLeft(2461);
        cardSlot.add(smallCards[1].init(8, 0)).padLeft(121);
        cardSlot.add(smallCards[2].init(8, 0)).padLeft(121);
        cardSlot.add(smallCards[3].init(8, 0)).padLeft(121);
        cardSlot.add(smallCards[4].init(8, 0)).padLeft(121);
        if (smallCardDeckCount < 5) {
            changeSmallCard(4, 7, 0);
            smallCardsChanged[4] = true;
        }
        if (smallCardDeckCount < 4) {
            changeSmallCard(3, 7, 0);
            smallCardsChanged[3] = true;
        }
        if (smallCardDeckCount < 3) {
            changeSmallCard(2, 7, 0);
            smallCardsChanged[2] = true;
        }
        if (smallCardDeckCount < 2) {
            changeSmallCard(1, 7, 0);
            smallCardsChanged[1] = true;
        }
        if (smallCardDeckCount < 1) {
            changeSmallCard(0, 7, 0);
            smallCardsChanged[0] = true;
        }

        cardSlot.getCells().get(0).getActor().setZIndex(0);
        cardSlot.getCells().get(1).getActor().setZIndex(1);
        cardSlot.getCells().get(2).getActor().setZIndex(2);
        cardSlot.getCells().get(3).getActor().setZIndex(3);
        cardSlot.getCells().get(4).getActor().setZIndex(4);

        cardSlot.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int smallCardIndexDnD = event.getTarget().getParent().getZIndex();
                if (smallCards[smallCardIndexDnD].getIndex() < 7) {
                    if (smallCardIndexDnD == 0) {
                        cardDeck.getCells().get(cardZIndex).clearActor().setActor(cards[cardZIndex].init(smallCards[smallCardIndexDnD].getIndex(), smallCards[smallCardIndexDnD].getPriority()));
                        cardDeck.getCells().get(cardZIndex).getActor().setZIndex(cardZIndex);
                        smallCardsChanged[smallCardIndexDnD] = false;
                        cardSlot.getCells().get(smallCardIndexDnD).setActor(smallCards[smallCardIndexDnD].init(8, 0));
                        cardDeck.getCells().get(smallCardIndexDnD).getActor().setZIndex(smallCardIndexDnD);
                    }
                    if (smallCardIndexDnD == 1) {
                        cardDeck.getCells().get(card2ZIndex).clearActor().setActor(cards[card2ZIndex].init(smallCards[smallCardIndexDnD].getIndex(), smallCards[smallCardIndexDnD].getPriority()));
                        cardDeck.getCells().get(card2ZIndex).getActor().setZIndex(card2ZIndex);
                        smallCardsChanged[smallCardIndexDnD] = false;
                        cardSlot.getCells().get(smallCardIndexDnD).setActor(smallCards[smallCardIndexDnD].init(8, 0));
                        cardDeck.getCells().get(smallCardIndexDnD).getActor().setZIndex(smallCardIndexDnD);
                    }
                    if (smallCardIndexDnD == 2) {
                        cardDeck.getCells().get(card3ZIndex).clearActor().setActor(cards[card3ZIndex].init(smallCards[smallCardIndexDnD].getIndex(), smallCards[smallCardIndexDnD].getPriority()));
                        cardDeck.getCells().get(card3ZIndex).getActor().setZIndex(card3ZIndex);
                        smallCardsChanged[smallCardIndexDnD] = false;
                        cardSlot.getCells().get(smallCardIndexDnD).setActor(smallCards[smallCardIndexDnD].init(8, 0));
                        cardDeck.getCells().get(smallCardIndexDnD).getActor().setZIndex(smallCardIndexDnD);
                    }
                    if (smallCardIndexDnD == 3) {
                        cardDeck.getCells().get(card4ZIndex).clearActor().setActor(cards[card4ZIndex].init(smallCards[smallCardIndexDnD].getIndex(), smallCards[smallCardIndexDnD].getPriority()));
                        cardDeck.getCells().get(card4ZIndex).getActor().setZIndex(card4ZIndex);
                        smallCardsChanged[smallCardIndexDnD] = false;
                        cardSlot.getCells().get(smallCardIndexDnD).setActor(smallCards[smallCardIndexDnD].init(8, 0));
                        cardDeck.getCells().get(smallCardIndexDnD).getActor().setZIndex(smallCardIndexDnD);
                    }
                    if (smallCardIndexDnD == 4) {
                        cardDeck.getCells().get(card5ZIndex).clearActor().setActor(cards[card5ZIndex].init(smallCards[smallCardIndexDnD].getIndex(), smallCards[smallCardIndexDnD].getPriority()));
                        cardDeck.getCells().get(card5ZIndex).getActor().setZIndex(card5ZIndex);
                        smallCardsChanged[smallCardIndexDnD] = false;
                        cardSlot.getCells().get(smallCardIndexDnD).setActor(smallCards[smallCardIndexDnD].init(8, 0));
                        cardDeck.getCells().get(smallCardIndexDnD).getActor().setZIndex(smallCardIndexDnD);
                    }
                }

            }
        });
        return cardSlot;
    }

    public void changeSmallCard(int cardIndex, int index, int priority) {
        cardSlot.getCells().get(cardIndex).clearActor().setActor(smallCards[cardIndex].init(index, priority));
    }

    public boolean allSmallCardsChanged() {
        boolean allEqual = true;
        for (boolean bool : smallCardsChanged) {
            if (!bool) {
                allEqual = false;
                break;
            }
        }
        return !allEqual;
    }
    //PLAYER CARD HAND

    //CARD DECK
    public Table CardDeck() {
        cardDeck.padLeft(4420).padBottom(1200);
        cardDeck.setTouchable(Touchable.enabled);
        Random random = new Random();

        for (int i = 0; i < cardDeckCount; i++) {
            cards[i] = new Card();
        }

        if (cards.length > 0) {
            cardDeck.add(cards[0].init(random.nextInt(6), random.nextInt(1999)));
        }
        if (cards.length > 1) {
            cardDeck.add(cards[1].init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        }
        if (cards.length > 2) {
            cardDeck.row().padTop(275);
            cardDeck.add(cards[2].init(random.nextInt(6), random.nextInt(1999)));
        }
        if (cards.length > 3) {
            cardDeck.add(cards[3].init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        }
        if (cards.length > 4) {
            cardDeck.row().padTop(275);
            cardDeck.add(cards[4].init(random.nextInt(6), random.nextInt(1999)));
        }
        if (cards.length > 5) {
            cardDeck.add(cards[5].init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        }
        if (cards.length > 6) {
            cardDeck.row().padTop(275);
            cardDeck.add(cards[6].init(random.nextInt(6), random.nextInt(1999)));
        }
        if (cards.length > 7) {
            cardDeck.add(cards[7].init(random.nextInt(6), random.nextInt(1999))).padLeft(205);
        }
        if (cards.length > 8) {
            cardDeck.row().padTop(275);
            cardDeck.add(cards[8].init(random.nextInt(6), random.nextInt(1999)));
        }
        return cardDeck;
    }

    public Card getCard(int cardIndex) {
        return (Card) cards[cardIndex];
    }
    //CARD DECK
}
